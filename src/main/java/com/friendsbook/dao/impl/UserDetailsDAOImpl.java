package com.friendsbook.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.friendsbook.dao.UserDetailsDAO;
import com.friendsbook.model.UserDetails;

@Repository(value="userDetailsDAO")
@Transactional
public class UserDetailsDAOImpl implements UserDetailsDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean insertOrUpdateUserDetails(UserDetails userDetails)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}				
	}

	public UserDetails getUserDetails(String username)
	{
		Session session=sessionFactory.getCurrentSession();
		UserDetails userDetails=session.get(UserDetails.class,username);
		return userDetails;
	}

	public UserDetails getUserDetailsByEmail(String email)
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from UserDetails where email=:email");
		query.setParameter("email",email);
		return (UserDetails)query.uniqueResult();
	}

	public UserDetails login(UserDetails userDetails)
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from UserDetails where username=:username and password=:password");
		query.setParameter("username",userDetails.getUsername());
		query.setParameter("password",userDetails.getPassword());
		return (UserDetails)query.uniqueResult();
	}

}
