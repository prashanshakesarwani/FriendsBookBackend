package com.friendsbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendsbook.dao.FriendsDAO;
import com.friendsbook.model.Friends;
import com.friendsbook.model.UserDetails;
import com.friendsbook.service.FriendsService;

@Service(value="friendsService")
public class FriendsServiceImpl implements FriendsService
{
	
	@Autowired 
	private FriendsDAO friendsDAO;

	public List<UserDetails> getSuggestedFriends(String username) 
	{
		return friendsDAO.getSuggestedFriends(username);
	}

	public void addOrUpdateFriend(Friends friend) 
	{
		friendsDAO.addOrUpdateFriend(friend);
	}

	public List<UserDetails> getFriendRequests(String username)
	{
		return friendsDAO.getFriendRequests(username);
	}

	public List<UserDetails> getFriendsList(String username) 
	{
		return friendsDAO.getFriendsList(username);
	}

	public Friends getFriend(String toId, String fromId) 
	{
		return friendsDAO.getFriend(toId, fromId);
	}

	public List<UserDetails> getSentRequests(String username) 
	{
		return friendsDAO.getSentRequests(username);
	}

}
