package com.friendsbook.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.friendsbook.dao.JobDAO;
import com.friendsbook.model.ApplyForJob;
import com.friendsbook.model.Job;

@Repository(value="jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean insertOrUpdateJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}				
	}

	public boolean deleteJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(job);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}		
	}

	public List<Job> getJob() 
	{
		List<Job> job=new ArrayList<Job>();
		try
		{
			job=sessionFactory.getCurrentSession().createQuery("from Job").list();
			return job;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	public Job getJobById(int id) 
	{
		Session session = sessionFactory.getCurrentSession();
        return session.get(Job.class, id);
	}
	public List<ApplyForJob> getAllAppliedUser(int jobId)
	{
		Session session=sessionFactory.getCurrentSession();
		Query<ApplyForJob> query=session.createQuery("from ApplyForJob where applied_for=:id");
		query.setParameter("id", jobId);
		List<ApplyForJob> list=query.list();
		return list;
	}

	public void applyForJob(ApplyForJob applyForJob) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(applyForJob);
	}

	public boolean checkIfApplied(int jobId, String username)
	{
		Session session=sessionFactory.getCurrentSession();
		Query<ApplyForJob> query=session.createQuery("from ApplyForJob where applied_for=:id and applied_by.username=:username");
		query.setParameter("id", jobId);
		query.setParameter("username", username);
		if(query.uniqueResult()==null)
			return false;
		return true;
	}

}
