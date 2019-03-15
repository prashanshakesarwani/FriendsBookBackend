package com.friendsbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendsbook.dao.UserDetailsDAO;
import com.friendsbook.model.UserDetails;
import com.friendsbook.service.UserDetailsService;

@Service(value="userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService
{
	@Autowired
	private UserDetailsDAO userDetailsDAO;

	public boolean insertOrUpdateUserDetails(UserDetails userDetails)
	{
		if(userDetailsDAO.insertOrUpdateUserDetails(userDetails))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public UserDetails getUserDetails(String username)
	{
		return userDetailsDAO.getUserDetails(username);
	}

	public UserDetails getUserDetailsByEmail(String email) 
	{
		return userDetailsDAO.getUserDetailsByEmail(email);
	}

	public UserDetails login(UserDetails userDetails) 
	{
		return userDetailsDAO.login(userDetails);
	}

}
