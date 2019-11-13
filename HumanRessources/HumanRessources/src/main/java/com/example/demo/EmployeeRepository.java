package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
	@Query("select e from Employee e where e.nom like :nom")
	public Page<Employee> employeeByNom(@Param("nom") String n, Pageable pageable);
	@Query("select e from Employee e where e.nom like :prenom")
	public Page<Employee> employeeByPrenom(@Param("prenom") String n, Pageable pageable);
	   
}