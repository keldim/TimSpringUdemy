package com.chrisyoo.springdemo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chrisyoo.springdemo.service.RandomizerRequestScope;
import com.chrisyoo.springdemo.service.RandomizerSessionScope;

@Controller
public class ScopeController {
	
	@Autowired
	RandomizerRequestScope randomizerRequestScope;
	
	@Autowired
	RandomizerSessionScope randomizerSessionScope;
	
	@RequestMapping("/")
	public void getRandom(HttpServletResponse response) throws Exception {
		response.setContentType("text/html");
		response.getWriter().write("************************* request scope ************************* <br>");
		response.getWriter().write("Old Number: " + randomizerRequestScope.getRandomNumber() + "<br>");
		randomizerRequestScope.generateRandomNumber();
		response.getWriter().write("New Number: " + randomizerRequestScope.getRandomNumber() + "<br>");
		response.getWriter().write("Object Reference: " + randomizerRequestScope + "<br>");
		
		response.getWriter().write("************************* session scope ************************* <br>");
		response.getWriter().write("Old Number: " + randomizerSessionScope.getRandomNumber() + "<br>");
		randomizerSessionScope.generateRandomNumber();
		response.getWriter().write("New Number: " + randomizerSessionScope.getRandomNumber() + "<br>");
		response.getWriter().write("Object Reference: " + randomizerSessionScope + "<br>");
	}
}
