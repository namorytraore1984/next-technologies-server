package com.nexttechnologies.nexttechnologiesserver.api.v1.controller;

import com.nexttechnologies.nexttechnologiesserver.models.AppUser;
import com.nexttechnologies.nexttechnologiesserver.services.LoginService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserManagerController {

	//@Autowired
	private final LoginService loginService;

	public UserManagerController(LoginService loginService) {
		this.loginService = loginService;
	}

	
	@GetMapping
	public String testEndpoint() throws Exception {
		return "Controller works well";
		
	}

	@GetMapping("/{username}")
	public ResponseEntity<AppUser> getUser(@PathVariable String username) throws Exception {
		AppUser user = loginService.loadUser(username);
		AppUser user1 = new AppUser();
		user1.setUsername("Amine");
		//return ResponseEntity.ok().body(user1);
		return ResponseEntity.ok().body(user);
	}
}