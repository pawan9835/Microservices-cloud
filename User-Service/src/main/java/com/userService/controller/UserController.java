package com.userService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userService.entity.User;
import com.userService.model.ResponseTemplate;
import com.userService.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(value = "/saveUser")
	public User saveUser(@RequestBody User user) {
		final String methodName = "saveUser";
		log.info("Entring Controller saveUser");
		    User usr = userService.saveUser(user);
		    
		return usr;
	}
	@GetMapping(value = "/getUserWithDepart/{userId}")
	public ResponseTemplate getUserWithDepartment(@PathVariable Long userId) {
		final String methodName = "saveUser";
		log.info("Entring Controller getUserWithDepart");
		return userService.getUserWithDepartment(userId);
	}
}
