package com.group.assignment.employeemanagement.services;

import java.util.List;

import com.group.assignment.employeemanagement.model.Employee;
import com.group.assignment.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {

	@Autowired
	private EmployeeRepository repo;
	
	public List<Employee> listAll(){
		return repo.findAll();
	}
	
	public void save(Employee employee) {
		repo.save(employee);
	}
	
	public Employee get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
}
