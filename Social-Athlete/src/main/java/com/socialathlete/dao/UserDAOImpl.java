package com.socialathlete.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.NoResultException;


import org.springframework.stereotype.Service;

import com.socialathlete.domain.SATeam;
import com.socialathlete.domain.SAUser;
import com.socialathlete.domain.SAPlayer;
import com.socialathlete.web.SACreateAccountController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Service
public class UserDAOImpl implements UserDAO {
	
	private EntityManagerFactory emf;
	
	private static final Log log = LogFactory.getLog(UserDAOImpl.class);
	
	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }
	
	public List<String> getPlayersByTeam(String team){
		EntityManager em = this.emf.createEntityManager();
		try {
			
			Query query = em.createQuery("SELECT p.twitterAccount from SAPlayer p join p.team t where t.teamName = ?1");
			query.setParameter(1, team);
			List results = query.getResultList();
			ArrayList <String> result = new ArrayList();
			log.error("Number of results: " + results.size());
			if(results.size()!= 0)
			{
				Iterator it = results.iterator();
				while(it.hasNext())
				{
					result.add((String) it.next());
				}
				
			}
			
			return result;
		}
		catch(Exception e)
		{
			log.error(e);
			
			List<String> to_return = new ArrayList();
			return to_return;
		}
		finally {
			if (em != null) {
				em.close();
			}
			
		}
	}
	
	public List<String> getTeamsByLeague(String league){
		EntityManager em = this.emf.createEntityManager();
		try {
			Query query = em.createQuery("SELECT st.teamName  from SATeam st join st.league p where p.leagueName = ?1");
			query.setParameter(1, league);
			List results = query.getResultList();
			ArrayList <String> result = new ArrayList();
			if(results.size()!= 0)
			{
				Iterator it = results.iterator();
				while(it.hasNext())
				{
					result.add((String) it.next());
				}
				
			}
			
			return result;
		}
		finally {
			if (em != null) {
				em.close();
			}
			
		}
	}
	
	public SAUser getUserbyUsername(String username){
		EntityManager em = this.emf.createEntityManager();
		try {
			
			SAUser result = null;
			
			try{
			Query query = em.createQuery("from SAUser u where u.username = ?1");
			query.setParameter(1, username);
			result = (SAUser) query.getSingleResult();
		
			}
			catch(Exception e)
			{
				result = null;
				return result;
			}
			
			
			return result;
		}
		finally {
			if (em != null) {
				em.close();
			}
			
		}
	}
	
	public void saveUser(SAUser user)
	{
		user.merge();
		
	}
	
	public SATeam getTeamByName(String team){
		EntityManager em = this.emf.createEntityManager();
		try {
			
			
			Query query = em.createQuery(" select OBJECT(t) from SATeam t where t.teamName = ?1");
			query.setParameter(1, team);
			SATeam result = (SATeam) query.getSingleResult();
			
			return result;
		}
		finally {
			if (em != null) {
				em.close();
			}
			
		}
	}
	
	public String getTeamByUserName(String username){
		EntityManager em = this.emf.createEntityManager();
		try {
			
			String result = "";
			
			try{
			Query query = em.createQuery("select u.following from SAUser u where u.username = ?1");
			query.setParameter(1, username);
			SATeam result_team = (SATeam) query.getSingleResult();
			result = result_team.getTeamName();
		
			}
			catch(Exception e)
			{
				log.error(e);
				
				result = null;
				return result;
			}
			
			
			return result;
		}
		finally {
			if (em != null) {
				em.close();
			}
			
		}
	}
	
}
