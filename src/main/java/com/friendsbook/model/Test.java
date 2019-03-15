package com.friendsbook.model;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test 
{
	public static void main(String ar[])
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	System.out.print("sdkgsdj");
	context.scan("com.friendsbook");
	System.out.print("sdkgsdj");
	context.refresh();
	context.close();
	}
}
