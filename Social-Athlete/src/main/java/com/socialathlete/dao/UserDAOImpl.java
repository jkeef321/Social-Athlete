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

import com.socialathlete.domain.SASocialAccount;
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
	
	public List<String> getFollowersByUserId(String userid){
		EntityManager em = this.emf.createEntityManager();
		try {
			Query query = em.createQuery("SELECT sa.accountHandle  from SAUser u join u.following p join p.socialAccount sa where u.username = ?1");
			query.setParameter(1, userid);
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
		user.persist();
		
	}
	
	public Set<SAPlayer> getPlayersByTeam(String team){
		EntityManager em = this.emf.createEntityManager();
		try {
			
			log.error("Team to search is : " + team);
			
			Query query = em.createQuery(" select OBJECT(sp) from SAPlayer sp join sp.team t where t.teamName = ?1");
			query.setParameter(1, team);
			List results = query.getResultList();
			HashSet<SAPlayer> result = new HashSet();
			
			log.error("Number of results: " + results.size());
			if(results.size()!= 0)
			{
				Iterator it = results.iterator();
				while(it.hasNext())
				{
					result.add((SAPlayer) it.next());
				}
				
			}
			log.debug("Number in result: " + result.size());
			
			return result;
		}
		finally {
			if (em != null) {
				em.close();
			}
			
		}
	}
	
	public Set<SASocialAccount> getSocialAccountByHandle(String handle)
	{
		EntityManager em = this.emf.createEntityManager();
		try {
			Query query = em.createQuery(" from SASocialAccount sa where sa.accountHandle = ?1");
			query.setParameter(1, handle);
			List results = query.getResultList();
			HashSet<SASocialAccount> result = new HashSet();
			if(results.size()!= 0)
			{
				Iterator it = results.iterator();
				while(it.hasNext())
				{
					result.add((SASocialAccount) it.next());
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
}
