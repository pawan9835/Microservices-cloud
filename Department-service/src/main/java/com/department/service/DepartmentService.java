package com.department.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.department.entity.Department;
import com.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	@Autowired
	private DepartmentRepository departRepo;

	public Department saveDepartment(Department department) {
		final String methodName = "saveDepartment";
		log.info("Entring Service saveDepartment.....");
		return departRepo.save(department);
	}

	public Department getDepartmentById(long deparmentId) {
		final String methodName = "getDepartmentById";
		log.info("Entring Service getDepartmentById......");
		Optional<Department> department = departRepo.findById(deparmentId);
                System.out.println(department.get());
		return department.get();
	}

	public List<Department> getAllDepartment() {
		final String methodName = "getAllDepartment";
		log.info("Entring Service getAllDepartment......");
		List<Department> departList = departRepo.findAll();
		return departList;
	}

	public String deleteDeleteById(long id) {
		final String methodName = "deleteDeleteById";
		log.info("Entring Service deleteDeleteById......");
		departRepo.deleteById(id);
		return "Deleted";
	}
}
