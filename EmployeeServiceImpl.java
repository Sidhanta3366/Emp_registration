package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.IEmployeeRepository;
import com.example.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	
	@Autowired
	private IEmployeeRepository emprepo;

	//save Employee Details
	@Override
	public boolean saveEmployeeDetails(Employee emp) {
		Optional<Employee> entity = null;
		if(emp.getId()== null) {
			entity = emprepo.findByempName(emp.getEmpName());
		}
		else {
			entity = emprepo.findByempNameAndIdNot(emp.getEmpName(), emp.getId());
		}
		
		if(entity.isEmpty()) {
			emprepo.save(emp);
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> getfindAllEmployeeDetails() {
		
		return emprepo.findAll();
	}

	@Override
	public boolean deleteEmployeeById(Long id) {
		emprepo.deleteById(id);
		return true;
		
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		Optional<Employee> entity = emprepo.findByempNameAndIdNot(emp.getEmpName(), emp.getId());
		
		if(entity.isEmpty()) {
			emprepo.save(emp);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	
	
}
