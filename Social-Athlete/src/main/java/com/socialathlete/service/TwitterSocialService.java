package com.socialathlete.service;

import java.util.List;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

import org.springframework.social.twitter.api.TimelineOperations;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import com.socialathlete.domain.SocialMessage;
import com.socialathlete.dao.UserDAO;
import com.socialathlete.dao.UserDAOImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Service
public class TwitterSocialService implements SocialService {
	
	private final Twitter twitter;
    
	private final UserDAO userDao;
	
	private static final Log log = LogFactory.getLog(UserDAOImpl.class);
	
	@Inject
	public TwitterSocialService(Twitter twitter, UserDAO userDao) {
		this.twitter = twitter;
		this.userDao = userDao;
	}
	
	public List <SocialMessage> getTimelineForFollowers(String userid)
	{
		//Get Followers
		log.error("Userid is: " + userid);
		String team = userDao.getTeamByUserName(userid);
		log.error("Team is: " + team);
		List <String> old_followers = userDao.getPlayersByTeam(team);
		List <SocialMessage> messages = new ArrayList();
		TimelineOperations timelineOps = twitter.timelineOperations();
		
		List<String> followers = new ArrayList<String>(new HashSet<String>(old_followers));
		
		for (String follower : followers)
		{
			
			List<Tweet> results = timelineOps.getUserTimeline(follower);
	    	for (Tweet tweet : results)
	    	{
	    		SocialMessage sm = new SocialMessage();
	    		sm.setProfileUrl(tweet.getProfileImageUrl());
	    		sm.setCreatedAt(tweet.getCreatedAt());
	    		sm.setMessage(tweet.getText());
	    		messages.add(sm);
	    	}
			
			
		}
		
		Collections.sort(messages, COMPARATOR);
		
		return messages;
	}
	
	private static Comparator<SocialMessage> COMPARATOR = new Comparator<SocialMessage>()
	{
		public int compare(SocialMessage s1, SocialMessage s2)
		{
			if (s1.getCreatedAt().before(s2.getCreatedAt())) {
	            return 1;
	        } else if (s1.getCreatedAt().after(s2.getCreatedAt())) {
	            return -1;
	        } else {
	            return 0;
	        } 
			
			
		}
	};
			

}
