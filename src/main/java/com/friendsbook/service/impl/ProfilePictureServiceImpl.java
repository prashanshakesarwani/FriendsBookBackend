package com.friendsbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendsbook.dao.ProfilePictureDAO;
import com.friendsbook.model.ProfilePicture;
import com.friendsbook.service.ProfilePictureService;

@Service(value="profilePictureService")
public class ProfilePictureServiceImpl implements ProfilePictureService
{
	@Autowired
	private ProfilePictureDAO profilePictureDAO;

	public boolean insertOrUpdateProfilePicture(ProfilePicture profilePicture) {
		if(profilePictureDAO.insertOrUpdateProfilePicture(profilePicture))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public ProfilePicture getProfilePicture(String username) 
	{
		return profilePictureDAO.getProfilePicture(username);
	}

}
