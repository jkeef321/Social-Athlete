package com.socialathlete.dao;

import java.util.List;
import com.socialathlete.domain.SAUser;
import com.socialathlete.domain.SAPlayer;
import com.socialathlete.domain.SATeam;
import java.util.Set;

public interface UserDAO {
	
	public String getTeamByUserName(String username);
	
	public List<String> getPlayersByTeam(String team);
	
	public List<String> getTeamsByLeague(String league);
	
	public SAUser getUserbyUsername(String username);
	
	public void saveUser(SAUser user);

	public SATeam getTeamByName(String team);
	
}
