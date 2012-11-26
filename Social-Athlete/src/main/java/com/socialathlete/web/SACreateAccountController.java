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

import com.socialathlete.dao.UserDAO;
import com.socialathlete.domain.SAUser;

@RequestMapping("/sacreateaccount/**")
@Controller
public class SACreateAccountController  {

    
	private final UserDAO userDao;
	
	@Inject
	public SACreateAccountController( UserDAO userDao) {
		this.userDao = userDao;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@ModelAttribute SAUser user ,Model model, @PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    	
    	userDao.saveUser(user);
    }

    @RequestMapping
    public String index(Model model ) {
        model.addAttribute("user", new SAUser());
    	return "sacreateaccount/index";
    }
}
