package com.socialathlete.dao;

import java.util.List;

public interface UserDAO {
	public List<String> getFollowersByUserId(String userid);
}
