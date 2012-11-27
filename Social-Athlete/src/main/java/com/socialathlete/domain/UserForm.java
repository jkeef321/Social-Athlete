package com.socialathlete.domain;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class UserForm {

	private String team_to_follow;
	
	private String twitter_handle;
	
	private String password;
	
	private String emailAddress;
	
	private String firstName;
	
	private String lastName;
}
