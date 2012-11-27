package com.socialathlete.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.socialathlete.dao.UserDAO;
import com.socialathlete.domain.UserForm;
import com.socialathlete.domain.SAUser;

@RequestMapping("/sacreateaccount/**")
@Controller
public class SACreateAccountController  {

	private static final Log log = LogFactory.getLog(SACreateAccountController.class);
	
	private final UserDAO userDao;
	
	@Inject
	public SACreateAccountController( UserDAO userDao) {
		
		this.userDao = userDao;
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public void post(@ModelAttribute UserForm user ,Model model, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    	
    	log.error("Value of user: " + user.getLastName());
		SAUser user_to_save = new SAUser();
		user_to_save.setEmailAddress(user.getEmailAddress());
		user_to_save.setEnabled(true);
		user_to_save.setFirstName(user.getFirstName());
		user_to_save.setFollowing(userDao.getPlayersByTeam(user.getTeam_to_follow()));
		user_to_save.setLastName(user.getLastName());
		user_to_save.setPassword(user.getPassword());
		user_to_save.setRole("ROLE_USER");
		user_to_save.setSocialAccounts(userDao.getSocialAccountByHandle(user.getTwitter_handle()));
		user_to_save.setUsername(user.getTwitter_handle());
		
		
		userDao.saveUser(user_to_save);
		
    }

    @RequestMapping
    public String index(Model model ) {
        model.addAttribute("user", new UserForm());
        log.error("Got HERE!");
        model.addAttribute("team_list", userDao.getTeamsByLeague("MLS"));
        return "sacreateaccount/index";
    }
}
