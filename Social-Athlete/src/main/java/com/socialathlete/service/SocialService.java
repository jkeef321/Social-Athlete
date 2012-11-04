package com.socialathlete.service;

import java.util.List;
import com.socialathlete.domain.SocialMessage;

public interface SocialService {
	
	List <SocialMessage> getTimelineForFollowers(String userid);

}
