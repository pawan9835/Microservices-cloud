package com.userService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {
	private long departmentId;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;

}
