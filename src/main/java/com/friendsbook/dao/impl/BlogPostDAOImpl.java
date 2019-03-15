package com.friendsbook.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.friendsbook.dao.BlogPostDAO;
import com.friendsbook.model.BlogComment;
import com.friendsbook.model.BlogPost;
import com.friendsbook.model.UserDetails;


@Repository(value="blogPostDAO")
@Transactional
public class BlogPostDAOImpl implements BlogPostDAO
{
	 @Autowired
	 SessionFactory sessionFactory;
	 
	 public  BlogPost getBlogPostById(int id)
	    {
	        Session session = sessionFactory.getCurrentSession();
	        return session.get(BlogPost.class, id);
	    }

	public boolean insertOrUpdateBlogPost(BlogPost blogPost)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(blogPost);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}		
	}

	public List<BlogPost> getBlogPosts(String approved) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query<BlogPost> query=session.createQuery("from BlogPost where approved=:approved");
		query.setParameter("approved",approved);
		return query.list();
	}

	public List<BlogPost> getBlogPostsByUser(UserDetails user) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(BlogPost.class);
			criteria.add((Restrictions.eq("user", user)));
			List<BlogPost> BlogPostByUser=criteria.list();
			return BlogPostByUser;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	public boolean deleteBlogPost(BlogPost blogPost)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(blogPost);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public void addBlogComment(BlogComment blogComment) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(blogComment);		
	}

	public List<BlogComment> getAllBlogComment(int blog_id) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query<BlogComment> query=session.createQuery("from BlogComment where blogPost.blog_id=:id");
		query.setParameter("id",blog_id);
		return query.list();
	}
}
