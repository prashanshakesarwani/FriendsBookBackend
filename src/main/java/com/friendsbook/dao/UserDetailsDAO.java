package com.friendsbook.dao;
import com.friendsbook.model.UserDetails;

public interface UserDetailsDAO 
{
	public boolean insertOrUpdateUserDetails(UserDetails userDetails);
	public UserDetails getUserDetails(String username);
	public UserDetails getUserDetailsByEmail(String email);
	public UserDetails login(UserDetails userDetails);
}
