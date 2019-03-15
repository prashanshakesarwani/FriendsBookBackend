package com.friendsbook.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.friendsbook.dao.ProfilePictureDAO;
import com.friendsbook.model.ProfilePicture;

@Repository(value="profilePictureDAO")
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean insertOrUpdateProfilePicture(ProfilePicture profilePicture) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(profilePicture);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public ProfilePicture getProfilePicture(String username) 
	{
		Session session=sessionFactory.getCurrentSession();
		return session.get(ProfilePicture.class,username);
	}

}
