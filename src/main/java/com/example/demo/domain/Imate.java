package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


	@Entity
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	public class Imate extends Person implements Serializable{
		private static final long serialVersionUID = 1L;
		
	
	
    @Lob // Para armazenar texto longo, sem limite específico
	private String commitedCrime;

	@OneToMany(mappedBy ="imate")
    @JsonIgnoreProperties("imates")
	private List<Address> addresses = new ArrayList<>(); 
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	 private List<Phone> phones;
	
    
	@ManyToMany(mappedBy = "imates")
	//@JsonBackReference
    private List<ImateVisitors> visitors;
	

	public Imate() {
		
	}


	public Imate(Integer id, String gender, LocalDate dateOfBirth, String name, Integer socialSecurity,
			String commitedCrime) {
		super(id, gender, dateOfBirth, name, socialSecurity);
		this.commitedCrime = commitedCrime;
	}

	public String getCommitedCrime() {
		return commitedCrime;
	}

	public void setCommitedCrime(String commitedCrime) {
		this.commitedCrime = commitedCrime;
	}

	

	public List<Address> getAddresses() {
		return addresses;
	}


	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}


	public List<ImateVisitors> getVisitors() {
		return visitors;
	}

	public void setVisitors(List<ImateVisitors> visitors) {
		this.visitors = visitors;
	}


	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	
	
}
 