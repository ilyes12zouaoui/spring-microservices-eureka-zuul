package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Page;


@Service
public class EmployeeService  {

	@Autowired
	private EmployeeRepository employeeRepository;
	

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	public Employee updateEmployee(int id, Employee newEmployee) {
		if (employeeRepository.findById(id).isPresent()) {
			Employee existingEmployee = employeeRepository.findById(id).get();
			existingEmployee.setNom(newEmployee.getNom());
			existingEmployee.setPrenom(newEmployee.getPrenom());
			existingEmployee.setEmail(newEmployee.getEmail());

			return employeeRepository.save(existingEmployee);
		} else
			return null;
	}
	public String deleteEmployee(int id) {
		if (employeeRepository.findById(id).isPresent()) {
			employeeRepository.deleteById(id);
			return "employee deleted";
		} else
			return "employee not deleted";
	}
	public Page<Employee> findEmplyeeByName(String n,Pageable pageable){
		Page<Employee> ListEmployee = employeeRepository.employeeByNom(n, pageable);
		return ListEmployee;
	}
	public Page<Employee> findEmplyeeByLastName(String n,Pageable pageable){
		Page<Employee> ListEmployee = employeeRepository.employeeByPrenom(n, pageable);
		return ListEmployee;
	}
	
	public String affecterEmployeOffre( ) {
		return "approuvé";
	}
}

