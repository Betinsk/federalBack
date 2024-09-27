package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
public class Imate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer age;
	private String gender;
	private String name;
	private Integer socialSecurity;

	@OneToMany(mappedBy ="imate")
	private List<Address> addresses = new ArrayList<>(); 
	
	@ManyToMany(mappedBy = "imates")
    @JsonIgnoreProperties("imates")
    private List<ImateVisitors> visitors;
	

	public Imate() {
		
	}

	public Imate(Integer id, Integer age, String gender, String name, Integer socialSecurity) {
		super();
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.name = name;
		this.socialSecurity = socialSecurity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
		Imate other = (Imate) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
 