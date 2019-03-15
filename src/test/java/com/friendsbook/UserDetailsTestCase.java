package com.friendsbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.friendsbook.model.UserDetails;
import com.friendsbook.service.UserDetailsService;


public class UserDetailsTestCase 
{
	UserDetailsService userDetailsService;
	AnnotationConfigApplicationContext context;
	UserDetails userDetails;
	
	@Before
	public void setUp()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.friendsbook");
		context.refresh();
		userDetails = (UserDetails)context.getBean("userDetails");
		userDetailsService=(UserDetailsService)context.getBean("userDetailsService"); 
	}
	
	@Test
	public void insertOrUpdateUserDetails()
	{
		boolean result;
		userDetails.setFirstname("Prashansha");
		userDetails.setLastname("Kesarwani");
		userDetails.setUsername("prashanshakesarwani");
		userDetails.setAddress("Gurgaon");
		userDetails.setMobile(993456789);
		userDetails.setOnline_status(false);
		userDetails.setRole("role_user");
		userDetails.setPassword("prasha12345");
		userDetails.setEmail("prashansha@gmail.com");
		result=userDetailsService.insertOrUpdateUserDetails(userDetails);
		if(result)
		{
			System.out.println("Added");
		}
		else
		{
			System.out.println("Error in adding");
		}
	}
	
	@After
	public void tearDown()
	{
		context.close();
	}
}
