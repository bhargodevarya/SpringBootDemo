package com.bhargo.microservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("user")
public class UserController {

	@RequestMapping("/hello")
	public void sayHello() {
		System.out.println("Hello!!!!");
	}
	
}
