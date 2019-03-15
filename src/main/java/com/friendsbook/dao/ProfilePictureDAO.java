package com.friendsbook.dao;
import com.friendsbook.model.ProfilePicture;

public interface ProfilePictureDAO 
{
	public boolean insertOrUpdateProfilePicture(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}
