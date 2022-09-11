package com.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeRepository employeeRepo;
	
	public List<Employee> listAll(){
	    return this.employeeRepo.findAll();
	}
	
	public Employee addEmployee(Employee e) {
		return this.employeeRepo.save(e);
	}
	public void deleteEmployee(Integer id) {
	    this.employeeRepo.deleteById(id);
	}
}
