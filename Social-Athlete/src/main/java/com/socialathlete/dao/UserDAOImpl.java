package com.socialathlete.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class UserDAOImpl implements UserDAO {
	
	private EntityManagerFactory emf;
	
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

}
