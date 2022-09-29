package com.userService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userService.entity.User;
import com.userService.model.Department;
import com.userService.model.ResponseTemplate;
import com.userService.userrepo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		final String methodName = "saveUser";
		log.info("Entring Service saveUser");

		return userRepo.save(user);
	}

	public ResponseTemplate getUserWithDepartment(Long userId) {

		ResponseTemplate rt = new ResponseTemplate();
		Optional<User> userOp = userRepo.findById(userId);
                User user = userOp.get();
		Department department = restTemplate
				.getForObject("http://DEPARTMENT-SERVICE/department/departId/"+ user.getDepartId(), Department.class);

		rt.setDepartment(department);
		rt.setUser(user);
		return rt;
	}

}
