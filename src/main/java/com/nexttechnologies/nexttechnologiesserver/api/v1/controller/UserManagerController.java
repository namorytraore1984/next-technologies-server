package com.nexttechnologies.nexttechnologiesserver.api.v1.controller;

import com.nexttechnologies.nexttechnologiesserver.services.LoginService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserManagerController {

	@NonNull
	private final LoginService loginService;
	
	@GetMapping
	public String testEndpoint() throws Exception {
		return "Controller works well";
	}
}