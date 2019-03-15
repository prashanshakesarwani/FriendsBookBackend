package com.friendsbook.service;

import com.friendsbook.model.ProfilePicture;

public interface ProfilePictureService 
{
	public boolean insertOrUpdateProfilePicture(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}
