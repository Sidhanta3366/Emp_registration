package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface IEmployeeService {

	public boolean saveEmployeeDetails(Employee emp);
	public List<Employee>  getfindAllEmployeeDetails();
	
	public boolean deleteEmployeeById(Long id);
	public boolean updateEmployee(Employee emp);
}
