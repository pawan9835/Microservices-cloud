package com.app.paw.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.paw.model.User;
import com.app.paw.service.IUserService;

@RestController
public class UserCOntroller {

	private IUserService userService;

	@GetMapping(value = "/allUsers")
	public List<User> getALlUsers() {

		List UserList = userService.getALlUsers();
		return UserList;
	}
}
