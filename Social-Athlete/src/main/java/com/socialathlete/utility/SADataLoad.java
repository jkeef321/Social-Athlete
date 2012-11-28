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
		
		log.error(event.getApplicationContext().getDisplayName());
		
		if(event.getApplicationContext().getDisplayName() == "Root WebApplicationContext")
		{
		log.error("Starting Data Load");
		
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
    	
    	SAAccountType twitter = new SAAccountType();
    	twitter.setPlatform("Twitter");
    	twitter.persist();
    	
    	SASocialAccount justin_sa = new SASocialAccount();
    	justin_sa.setAccountType(twitter);
    	justin_sa.setAccountHandle("keeferjustin");
    	justin_sa.persist();
    	
    	SASocialAccount todd_sa = new SASocialAccount();
    	todd_sa.setAccountType(twitter);
    	todd_sa.setAccountHandle("beginimage");
    	todd_sa.persist();
    	
    	SASocialAccount valdes_sa = new SASocialAccount();
    	valdes_sa.setAccountType(twitter);
    	valdes_sa.setAccountHandle("carlosvaldes5");
    	valdes_sa.persist();
    	
    	SASocialAccount zac_sa = new SASocialAccount();
    	zac_sa.setAccountType(twitter);
    	zac_sa.setAccountHandle("zacmacmath");
    	zac_sa.persist();
    	
    	SASocialAccount acosta_sa = new SASocialAccount();
    	acosta_sa.setAccountType(twitter);
    	acosta_sa.setAccountHandle("KellynAcosta");
    	acosta_sa.persist();
    	
    	SASocialAccount adu_sa = new SASocialAccount();
    	adu_sa.setAccountType(twitter);
    	adu_sa.setAccountHandle("FreddyAdu");
    	adu_sa.persist();
    	
    	SASocialAccount agudelo_sa = new SASocialAccount();
    	agudelo_sa.setAccountType(twitter);
    	agudelo_sa.setAccountHandle("jagudelo11");
    	agudelo_sa.persist();
    	
    	SAPlayer valdes = new SAPlayer();
    	valdes.setPlayerName("Carlos Valdes");
    	valdes.setTeam(philaunion);
    	HashSet valdes_hs = new HashSet();
    	valdes_hs.add(valdes_sa);
    	valdes.setSocialAccount(valdes_hs);
    	valdes.persist();
    	
    	SAPlayer zac = new SAPlayer();
    	zac.setPlayerName("Zac Macmath");
    	zac.setTeam(philaunion);
    	HashSet zac_hs = new HashSet();
    	zac_hs.add(zac_sa);
    	zac.setSocialAccount(zac_hs);
    	zac.persist();
    	
    	SAPlayer acosta = new SAPlayer();
    	acosta.setPlayerName("Kellyn Acosta");
    	acosta.setTeam(fcdallas);
    	HashSet acosta_hs = new HashSet();
    	acosta_hs.add(acosta_sa);
    	acosta.setSocialAccount(acosta_hs);
    	acosta.persist();
    	
    	SAPlayer adu = new SAPlayer();
    	adu.setPlayerName("Freddy Adu");
    	adu.setTeam(philaunion);
    	HashSet adu_hs = new HashSet();
    	adu_hs.add(adu_sa);
    	adu.setSocialAccount(adu_hs);
    	adu.persist();
    	
    	SAPlayer agudelo = new SAPlayer();
    	agudelo.setPlayerName("Juan Agudelo");
    	agudelo.setTeam(chivasusa);
    	HashSet agudelo_hs = new HashSet();
    	agudelo_hs.add(agudelo_sa);
    	agudelo.setSocialAccount(agudelo_hs);
    	agudelo.persist();
    	
    	
    	/*SAUser justin = new SAUser();
    	justin.setEmailAddress("justin@keefer.com");
    	justin.setFirstName("Justin");
    	HashSet jus_hs = new HashSet();
    	jus_hs.add(valdes);
    	jus_hs.add(zac);
    	justin.setFollowing(jus_hs);
    	justin.setLastName("Keefer");
    	justin.setPassword("password");
    	HashSet jus_hs_2 = new HashSet();
    	jus_hs_2.add(justin_sa);
    	justin.setSocialAccounts(jus_hs_2);
    	justin.setUsername("keeferjustin");
    	justin.setEnabled(true);
    	justin.setRole("ROLE_ADMIN");
    	justin.persist();
    	*/
    	
    	SAUser todd = new SAUser();
    	todd.setEmailAddress("tcoulson@gmail.com");
    	todd.setFirstName("Todd");
    	HashSet<SAPlayer> todd_hs = new HashSet<SAPlayer>();
    	todd_hs.add(valdes);
    	todd_hs.add(zac);
    	todd.setFollowing(todd_hs);
    	todd.setLastName("Coulson");
    	todd.setPassword("password");
    	HashSet<SASocialAccount> todd_hs_2 = new HashSet<SASocialAccount>();
    	todd_hs_2.add(todd_sa);
    	todd.setSocialAccounts(todd_hs_2);
    	todd.setUsername("beginimage");  
    	todd.setEnabled(true);
    	todd.setRole("ROLE_ADMIN");
    	todd.persist();
		}
	}

}
