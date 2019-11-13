package com.example.demo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Hotel implements Serializable{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private int nbStars;
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Offre> offre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public List<Offre> getOffre() {
		return offre;
	}
	public void setOffre(List<Offre> offre) {
		this.offre = offre;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNbStars() {
		return nbStars;
	}
	public void setNbStars(int nbStars) {
		this.nbStars = nbStars;
	}
	public Hotel() {
		super();
	}
	

}
