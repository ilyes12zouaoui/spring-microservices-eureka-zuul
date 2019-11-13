package com.example.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Employee implements Serializable{
	private static final long serialVersionUID = 6711457437559348053L;
	
	@Id
	@GeneratedValue
	private int id;
	private String nom, prenom,email;
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String nom) {
		super();
		this.nom = nom;
	}
	
@OneToMany(mappedBy = "employee")
public List<Leave> leaves= new ArrayList<>();
public List<Leave> getLeaves() {
	return leaves;
}
public void setLeaves(List<Leave> leaves) {
	this.leaves = leaves;
}
public void setId(int id) {
	this.id = id;
}


}
