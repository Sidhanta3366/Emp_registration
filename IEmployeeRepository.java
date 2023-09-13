package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long>{

	public Optional<Employee> findByempName(String empName);
	
	public Optional<Employee> findByempNameAndIdNot(String empName, Long id);
}
