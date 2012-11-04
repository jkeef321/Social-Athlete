package com.socialathlete.service;

import java.util.List;
import javax.inject.Inject;
import java.util.ArrayList;

import org.springframework.social.twitter.api.TimelineOperations;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import com.socialathlete.domain.SocialMessage;
import com.socialathlete.dao.UserDAO;

@Service
public class TwitterSocialService implements SocialService {
	
	private final Twitter twitter;
    
	private final UserDAO userDao;
	
	@Inject
	public TwitterSocialService(Twitter twitter, UserDAO userDao) {
		this.twitter = twitter;
		this.userDao = userDao;
	}
	
	public List <SocialMessage> getTimelineForFollowers(String userid)
	{
		//Get Followers
		List <String> followers = userDao.getFollowersByUserId(userid);
		List <SocialMessage> messages = new ArrayList();
		TimelineOperations timelineOps = twitter.timelineOperations();
		
		for (String follower : followers)
		{
			
			List<Tweet> results = timelineOps.getUserTimeline(follower);
	    	for (Tweet tweet : results)
	    	{
	    		SocialMessage sm = new SocialMessage();
	    		sm.setProfileUrl(tweet.getProfileImageUrl());
	    		sm.setCreatedAt(tweet.getCreatedAt().toString());
	    		sm.setMessage(tweet.getText());
	    		messages.add(sm);
	    	}
			
			
		}
		
		return messages;
	}

}
