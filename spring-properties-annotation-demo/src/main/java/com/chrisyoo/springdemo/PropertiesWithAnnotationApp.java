package com.chrisyoo.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.chrisyoo.springdemo.domain.Organization;

public class PropertiesWithAnnotationApp {
	public static void main(String[] args) {
		// create the application context (container)
		ApplicationContext ctx = new AnnotationConfigApplicationContext(PropertyConfig.class);
		Organization org = (Organization) ctx.getBean("myorg");
		System.out.println(org);
		System.out.println("slogan: " + org.corporateSlogan());
		
		// close the application context (container)
		((AnnotationConfigApplicationContext) ctx).close();
	}
}
