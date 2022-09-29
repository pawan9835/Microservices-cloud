package com.department.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.entity.Department;
import com.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/department")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departService;

	@PostMapping(value = "/saveDepartment")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Entring Controller saveDepartment");
		Department depart = departService.saveDepartment(department);

		return depart;
	}

	@GetMapping(value = "/departId/{deparmentId}")
	public Department getDepartmentById(@PathVariable long deparmentId) {
		final String methodName = "getDepartmentById";
		log.info("Entring Service getDepartmentById......");
		Department department = departService.getDepartmentById(deparmentId);

		return department;
	}

	@GetMapping(value = "/viewAll")
	public List<Department> getAllDepartment() {
		final String methodName = "getAllDepartment";
		log.info("Entring Controller getAllDepartment......");
		List<Department> departList = departService.getAllDepartment();
		return departList;
	}

	@DeleteMapping(value = "/deleteDepart/{id}")
	public String deleteDeleteById(@PathVariable int id) {
		List<Department> dList = null;
		final String methodName = "deleteDeleteById";
		log.info("Entring Controller deleteDeleteById......");
		String dlt = departService.deleteDeleteById(id);

		dList = departService.getAllDepartment();

		return "Deleted ";
	}

	@PutMapping(value = "/updateDepartment")
	public Department updateDepartment(@RequestBody Department department) {
		Department updDep = null;
		long dId = department.getDepartmentId();
		if (dId != 0) {
			Department dp = departService.getDepartmentById(dId);

			dp.setDepartmentAddress(department.getDepartmentAddress());
			dp.setDepartmentCode(department.getDepartmentCode());
			dp.setDepartmentName(department.getDepartmentName());

			if (dp != null) {
				updDep = departService.saveDepartment(dp);
			}
		}

		return updDep;
	}
}
