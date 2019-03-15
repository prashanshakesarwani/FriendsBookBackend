package com.friendsbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendsbook.dao.JobDAO;
import com.friendsbook.model.ApplyForJob;
import com.friendsbook.model.Job;
import com.friendsbook.service.JobService;

@Service(value="jobService")
public class JobServiceImpl implements JobService
{
	@Autowired
	private JobDAO jobDAO;

	public boolean insertOrUpdateJob(Job job) 
	{
		if(jobDAO.insertOrUpdateJob(job))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean deleteJob(Job job)
	{
		if(jobDAO.deleteJob(job))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public List<Job> getJob() 
	{
		List<Job> job=jobDAO.getJob();
		if(job!=null)
		{
			return job;
		}
		else
		{
			return null;
		}
	}

	public Job getJobById(int id) 
	{
		Job jobById=jobDAO.getJobById(id);
		if(jobById!=null)
		{
			return jobById;
		}
		else
		{
			return null;
		}
	}

	public List<ApplyForJob> getAllAppliedUser(int jobId)
	{
		return jobDAO.getAllAppliedUser(jobId);
	}

	public void applyForJob(ApplyForJob applyForJob) 
	{
		jobDAO.applyForJob(applyForJob);
	}

	public boolean checkIfApplied(int jobId, String username) 
	{
		return jobDAO.checkIfApplied(jobId, username);
	}

}
