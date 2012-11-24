package com.socialathlete.dao;

import java.util.List;
import com.socialathlete.domain.SAUser;

public interface UserDAO {
	public List<String> getFollowersByUserId(String userid);
	
	public List<String> getTeamsByLeague(String league);
	
	public SAUser getUserbyUsername(String username);
}
