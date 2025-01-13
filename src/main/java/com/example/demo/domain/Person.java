package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;


	@Entity
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
	public class Person implements Serializable{
	private static final long serialVersionUID = 1L; 
	
	@Id
	@SequenceGenerator(name = "sequence_generator", sequenceName = "person_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
	private Integer id;
	private String gender;
	private LocalDate dateOfBirth;
	private String name;
	private Integer socialSecurity;
	private String profileImage;
 
/*	@OneToMany(mappedBy ="person") 
	// @JsonIgnoreProperties("imates")
	private List<Address> addresses = new ArrayList<>(); 
	
	*/

	public Person() {
		
	}

	public Person(Integer id, String gender, LocalDate dateOfBirth, String name, Integer socialSecurity, String profileImage) {
		super();
		this.id = id;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.name = name;
		this.socialSecurity = socialSecurity;
		this.profileImage = profileImage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(Integer socialSecurity) {
		this.socialSecurity = socialSecurity;
	}
	
	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(id, other.id);
	}


	

}
