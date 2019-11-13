package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeRestApi {
	private String title = "Hello, I'm the employee Microservice";
	@Autowired
	private EmployeeService employeeService;
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
	}
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") int id,
    										@RequestBody Employee employee){
		return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
	}
	@GetMapping(value = "/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findByNom(@PathVariable(value = "nom") String nom,Pageable pageable){
		return (employeeService.findEmplyeeByName(nom, pageable).getContent());
	}
	@GetMapping(value = "/{prenom}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findByLastName(@PathVariable(value = "prenom") String prenom,Pageable pageable){
		return (employeeService.findEmplyeeByLastName(prenom, pageable).getContent());
	}
	@GetMapping("/approve")
	public String affecterEmployeOffre( ) {
		return employeeService.affecterEmployeOffre();
	}
}
