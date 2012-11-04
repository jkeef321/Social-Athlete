package com.socialathlete.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.socialathlete.domain.*;
import java.util.HashSet;

@RequestMapping("/sadataloader/**")
@Controller
public class SADataLoaderController {

    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index() {
        
    	SALeague mls = new SALeague();
    	mls.setLeagueName("MLS");
    	mls.persist();
    	
    	SATeam philaunion = new SATeam();
    	philaunion.setTeamName("Philadelphia Union");
    	philaunion.setLeague(mls);
    	philaunion.persist();
    	
    	SAAccountType twitter = new SAAccountType();
    	twitter.setPlatform("Twitter");
    	twitter.persist();
    	
    	SASocialAccount justin_sa = new SASocialAccount();
    	justin_sa.setAccountType(twitter);
    	justin_sa.setAccountHandle("keeferjustin");
    	justin_sa.persist();
    	
    	SASocialAccount valdes_sa = new SASocialAccount();
    	valdes_sa.setAccountType(twitter);
    	valdes_sa.setAccountHandle("carlosvaldes5");
    	valdes_sa.persist();
    	
    	SASocialAccount zac_sa = new SASocialAccount();
    	zac_sa.setAccountType(twitter);
    	zac_sa.setAccountHandle("zacmacmath");
    	zac_sa.persist();
    	
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
    	
    	SAUser justin = new SAUser();
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
    	justin.persist();
    	
    	return "sadataloader/index";
    }
}
