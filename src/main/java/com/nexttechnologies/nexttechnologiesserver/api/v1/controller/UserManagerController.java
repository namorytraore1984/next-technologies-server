package com.nexttechnologies.nexttechnologiesserver.api.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserManagerController {
	
	@GetMapping
	public String testEndpoint() throws Exception {
		return "Controller works well";
		
	}
}

