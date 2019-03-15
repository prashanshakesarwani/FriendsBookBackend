package com.friendsbook.dao;

import java.util.List;
import com.friendsbook.model.BlogComment;
import com.friendsbook.model.BlogPost;
import com.friendsbook.model.UserDetails;

public interface BlogPostDAO 
{
	boolean insertOrUpdateBlogPost(BlogPost blogPost);
	List<BlogPost> getBlogPosts(String approved);
	BlogPost getBlogPostById(int id);
	List<BlogPost> getBlogPostsByUser(UserDetails user);
	boolean deleteBlogPost(BlogPost blogPost);
	void addBlogComment(BlogComment blogComment);
	List<BlogComment> getAllBlogComment(int blog_id);
}
