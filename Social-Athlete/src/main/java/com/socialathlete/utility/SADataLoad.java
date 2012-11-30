package com.socialathlete.utility;

import java.util.HashSet;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.socialathlete.dao.UserDAOImpl;
import com.socialathlete.domain.*;

@Component
public class SADataLoad implements ApplicationListener<ContextRefreshedEvent>{

	private static final Log log = LogFactory.getLog(SADataLoad.class);
	
	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		//log.error(event.getApplicationContext().getDisplayName());
		
		if(event.getApplicationContext().getDisplayName() == "Root WebApplicationContext")
		{
		//log.error("Starting Data Load");
		
		SALeague mls = new SALeague();
    	mls.setLeagueName("MLS");
    	mls.persist();
    	
    	SATeam philaunion = new SATeam();
    	philaunion.setTeamName("Philadelphia Union");
    	philaunion.setLeague(mls);
    	philaunion.persist();
    	
    	SATeam fcdallas = new SATeam();
    	fcdallas.setTeamName("FC Dallas");
    	fcdallas.setLeague(mls);
    	fcdallas.persist();
    	
    	SATeam chivasusa = new SATeam();
    	chivasusa.setTeamName("Chivas USA");
    	chivasusa.setLeague(mls);
    	chivasusa.persist();
    	
    	SAPlayer valdes = new SAPlayer();
    	valdes.setPlayerName("Carlos Valdes");
    	valdes.setTeam(philaunion);
    	valdes.setTwitterAccount("carlosvaldes5");
    	valdes.persist();
    	
    	SAPlayer zac = new SAPlayer();
    	zac.setPlayerName("Zac Macmath");
    	zac.setTeam(philaunion);
    	zac.setTwitterAccount("zacmacmath");
    	zac.persist();
    	
    	SAPlayer acosta = new SAPlayer();
    	acosta.setPlayerName("Kellyn Acosta");
    	acosta.setTeam(fcdallas);
    	acosta.setTwitterAccount("KellynAcosta");
    	acosta.persist();
    	
    	SAPlayer adu = new SAPlayer();
    	adu.setPlayerName("Freddy Adu");
    	adu.setTeam(philaunion);
    	adu.setTwitterAccount("FreddyAdu");
    	adu.persist();
    	
    	SAPlayer agudelo = new SAPlayer();
    	agudelo.setPlayerName("Juan Agudelo");
    	agudelo.setTeam(chivasusa);
    	agudelo.setTwitterAccount("jagudelo11");
    	agudelo.persist();
    	
    	SAUser todd = new SAUser();
    	todd.setEmailAddress("tcoulson@gmail.com");
    	todd.setFirstName("Todd");
    	todd.setFollowing(philaunion);
    	todd.setLastName("Coulson");
    	todd.setPassword("password");
    	todd.setUsername("beginimage");  
    	todd.setEnabled(true);
    	todd.setRole("ROLE_ADMIN");
    	todd.persist();
		}
	}

}
