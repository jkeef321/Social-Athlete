package com.socialathlete.dao;

import java.util.List;
import com.socialathlete.domain.SAUser;
import com.socialathlete.domain.SAPlayer;
import com.socialathlete.domain.SASocialAccount;
import java.util.Set;

public interface UserDAO {
	public List<String> getFollowersByUserId(String userid);
	
	public List<String> getTeamsByLeague(String league);
	
	public SAUser getUserbyUsername(String username);
	
	public void saveUser(SAUser user);

	public Set<SAPlayer> getPlayersByTeam(String team);
	
	public Set<SASocialAccount> getSocialAccountByHandle(String handle);
}
