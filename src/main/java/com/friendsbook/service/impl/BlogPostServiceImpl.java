package com.friendsbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendsbook.dao.BlogPostDAO;
import com.friendsbook.model.BlogComment;
import com.friendsbook.model.BlogPost;
import com.friendsbook.model.UserDetails;
import com.friendsbook.service.BlogPostService;

@Service(value="blogPostService")
public class BlogPostServiceImpl implements BlogPostService
{
	
	@Autowired
	private BlogPostDAO blogPostDAO;
	
	public boolean insertOrUpdateBlogPost(BlogPost blogPost) 
	{
		if(blogPostDAO.insertOrUpdateBlogPost(blogPost))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public List<BlogPost> getBlogPosts(String approved) {
		List<BlogPost> blogPost=blogPostDAO.getBlogPosts(approved);
		if(blogPost!=null)
		{
			return blogPost;
		}
		else
		{
			return null;
		}
	}

	public BlogPost getBlogPostById(int id) 
	{
		BlogPost blogPostById=blogPostDAO.getBlogPostById(id);
		if(blogPostById!=null)
		{
			return blogPostById;
		}
		else
		{
			return null;
		}
	}

	public List<BlogPost> getBlogPostsByUser(UserDetails user) 
	{
		List<BlogPost> blogPostByUser=blogPostDAO.getBlogPostsByUser(user);
		if(blogPostByUser!=null)
		{
			return blogPostByUser;
		}
		else
		{
			return null;
		}
	}

	public boolean deleteBlogPost(BlogPost blogPost)
	{
		if(blogPostDAO.deleteBlogPost(blogPost))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void addBlogComment(BlogComment blogComment) 
	{
		blogPostDAO.addBlogComment(blogComment);
	}

	public List<BlogComment> getAllBlogComment(int blog_id) 
	{
		List<BlogComment> allBlogComment=blogPostDAO.getAllBlogComment(blog_id);
		if(allBlogComment!=null)
		{
			return allBlogComment;
		}
		else
		{
			return null;
		}
	}
	
}
