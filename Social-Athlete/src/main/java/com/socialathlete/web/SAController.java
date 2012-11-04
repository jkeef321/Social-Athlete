package com.socialathlete.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.context.request.WebRequest;
import javax.inject.Inject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.socialathlete.service.SocialService;
import com.socialathlete.domain.SocialMessage;

@RequestMapping("/sa/**")
@Controller
public class SAController {
	
	private final SocialService socialService;
    
	@Inject
	public SAController(SocialService socialService) {
		this.socialService = socialService;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }
    
	@RequestMapping
	public String index(WebRequest request, Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); 
		
		List <SocialMessage> results = socialService.getTimelineForFollowers(username);
		
		model.addAttribute("messages", results);
		
		return "sa/index";
	}
	    
}
