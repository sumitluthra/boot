package com.sumit.boot.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.boot.beans.BasicAuthenticationBean;

@RestController
//@Controller
@CrossOrigin(origins = "http://localhost:4000")
public class BasicAuthController {

	@GetMapping(value = "/hello")
	public String helloWorld() {
		return "Hello Spring Boot!!";
	}

	@GetMapping(value = "/hello-bean")
	public /* @ResponseBody */ BasicAuthenticationBean helloWorldBean() {
		throw new RuntimeException("Testing error handler for react axios catch");
	//	return new HelloWorldBean("Hello World Bean");
	}
	
	@GetMapping(value = "/basicAuth")
	public BasicAuthenticationBean basicAuth() {
		System.out.println("basic Auth request");
		return new BasicAuthenticationBean("You are authenticated");
	}
}
