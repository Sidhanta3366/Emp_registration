package com.example.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.IEmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	//Save Employee
	@RequestMapping(value = "save", method= RequestMethod.POST,produces = "application/json")
	public ResponseEntity<String> insertData(@RequestBody Employee emp){
		boolean saved = service.saveEmployeeDetails(emp);
		
		if(saved) {
			return ResponseEntity.ok("Employee data saved");
		}
		else {
			return ResponseEntity.ok("duplicate record");
		}
	}
	
	
	//getAll Employee
	@RequestMapping(value = "/getAllEmployee", method= RequestMethod.GET,produces = "application/json")
	public ResponseEntity<String> getAllEmployee(){
		return ResponseEntity.ok("get all EmployeeDetails"+ service.getfindAllEmployeeDetails());
	}
	
	//delete Employee id
	@RequestMapping(value = "/delete/{id}", method= RequestMethod.DELETE,produces = "application/json")
	public ResponseEntity<String> deleteByid(@PathVariable Long id){
		boolean val = service.deleteEmployeeById(id);
		
		if(val == true) {
			return ResponseEntity.ok("Employee deleted");
		}
		else {
			return ResponseEntity.ok("fail");
		}
	}
	
	//update Employee
	@RequestMapping(value = "/update", method= RequestMethod.PUT,produces = "application/json")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp){
		boolean update = service.updateEmployee(emp);
		
		if(update) {
			return ResponseEntity.ok("Employee data updated");
		}
		else {
			return ResponseEntity.ok("duplicate record");
		}
	}
	
}
