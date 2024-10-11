package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;


	@Entity
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	public class Imate extends Person implements Serializable{
		private static final long serialVersionUID = 1L;
		
		
	
    @Lob // Para armazenar texto longo, sem limite específico
	private String commitedCrime;

/*	@OneToMany(mappedBy ="imate")
    @JsonIgnoreProperties("imates")
	private List<Address> addresses = new ArrayList<>(); 
	
	*/
    
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

	

	public List<ImateVisitors> getVisitors() {
		return visitors;
	}

	public void setVisitors(List<ImateVisitors> visitors) {
		this.visitors = visitors;
	}




	
	
}
 