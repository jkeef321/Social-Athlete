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
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/sa/**")
@Controller
public class SAController {
	
	private final Twitter twitter = new TwitterTemplate();
    
	
	@RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public ModelAndView index() {
        
     	
    	TimelineOperations timelineOps = twitter.timelineOperations();
		List<Tweet> results = timelineOps.getUserTimeline("carlosvaldes5");
    	
		results.addAll(timelineOps.getUserTimeline("zacmacmath"));
		
    	return new ModelAndView("sa/index", "tweets", results);
    }
    
    
}
