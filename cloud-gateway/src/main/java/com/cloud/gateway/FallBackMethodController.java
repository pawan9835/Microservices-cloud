package com.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

	@GetMapping(value = "/userServiceFallack")
	public String userServiceFallBackMethod() {

		String msg = "User Servcie is taking longer than expected , Please Try agian later !";
		return msg;
	}
	
	@GetMapping(value = "/departmentServiceFallack")
	public String departmentServiceFallBackMethod() {

		String msg = "Department Servcie is taking longer than expected , Please Try agian later !";
		return msg;
	}

}
