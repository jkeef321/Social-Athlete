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
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.*;
import org.springframework.ui.Model;
import org.springframework.social.oauth1.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/sa/**")
@Controller
public class SAController {
	
	private Twitter twitter;
    
	private String consumerKey = "";
	private String consumerSecret = "";
	
	@RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index(WebRequest request) {
        
    	TwitterConnectionFactory connectionFactory = new TwitterConnectionFactory(consumerKey,consumerSecret);
    	OAuth1Operations oauthOperations = connectionFactory.getOAuthOperations();
    	OAuthToken requestToken = oauthOperations.fetchRequestToken( "http://www.social-athlete.com:8080/Social-Athlete/sa/twitterreturn", null );
    	
    	request.setAttribute("twitter_req_token", requestToken, WebRequest.SCOPE_SESSION);
    	
    	String authorizeUrl = oauthOperations.buildAuthorizeUrl(requestToken.getValue(), OAuth1Parameters.NONE);
    	
    	return "redirect:" + authorizeUrl;
    }
    
    @RequestMapping(value = "/sa/twitterreturn", method = RequestMethod.GET, params = "oauth_token")
    public String twitterreturn(@RequestParam(value = "oauth_verifier", defaultValue = "verifier") String verifier,
            WebRequest request, Model model){
    	
    	OAuthToken requestToken = (OAuthToken) request.getAttribute("twitter_req_token", WebRequest.SCOPE_SESSION);
    	
    	TwitterConnectionFactory connectionFactory = new TwitterConnectionFactory(consumerKey,consumerSecret);
    	OAuth1Operations oauthOperations = connectionFactory.getOAuthOperations();
    	
    	OAuthToken accessToken = oauthOperations.exchangeForAccessToken(
    		    new AuthorizedRequestToken(requestToken, verifier), null);
    	
    	twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken.getValue(), accessToken.getSecret());
    	TimelineOperations timelineOps = twitter.timelineOperations();
		List<Tweet> results = timelineOps.getUserTimeline("carlosvaldes5");
    	
		results.addAll(timelineOps.getUserTimeline("zacmacmath"));
		
		TwitterProfile profile = twitter.userOperations().getUserProfile();
		
		String user_name_twitter = profile.getName();
		
		model.addAttribute("tweets", results);
		model.addAttribute("user_name", user_name_twitter);
		return "sa/index";
    }
    
    
}
