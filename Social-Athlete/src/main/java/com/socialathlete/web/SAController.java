package com.socialathlete.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.social.twitter.api.TimelineOperations;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.ui.Model;
import org.springframework.web.context.request.WebRequest;
import javax.inject.Inject;

@RequestMapping("/sa/**")
@Controller
public class SAController {
	
	private final Twitter twitter;
    
	@Inject
	public SAController(Twitter twitter) {
		this.twitter = twitter;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }
    
	@RequestMapping
	public String index(WebRequest request) {
		
		return "sa/index";
	}
	
    @RequestMapping(value = "/sa/twitterhome", method = RequestMethod.POST)
    public String twitterhome(WebRequest request, Model model){
    	    	
    	TimelineOperations timelineOps = twitter.timelineOperations();
		List<Tweet> results = timelineOps.getUserTimeline("carlosvaldes5");
    	
		results.addAll(timelineOps.getUserTimeline("zacmacmath"));
		
		TwitterProfile profile = twitter.userOperations().getUserProfile();
		
		String user_name_twitter = profile.getName();
		
		model.addAttribute("tweets", results);
		model.addAttribute("user_name", user_name_twitter);
		return "twitterhome";
    }
    
    
}
