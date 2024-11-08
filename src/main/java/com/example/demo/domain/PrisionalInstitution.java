package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.enums.SecurityLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PrisionalInstitution implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	// private String picture;
	private SecurityLevel securityLevel;
	private Date establishmentDate;
	private Integer currentPopulation;
	private Integer capacity;
	private String description;
	private Address address;
	
	public PrisionalInstitution() {
		
	}

	public PrisionalInstitution(String name, SecurityLevel securityLevel, Date establishmentDate,
			Integer currentPopulation, Integer capacity, String description, Address address) {
		super();
		this.name = name;
		this.securityLevel = securityLevel;
		this.establishmentDate = establishmentDate;
		this.currentPopulation = currentPopulation;
		this.capacity = capacity;
		this.description = description;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SecurityLevel getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(SecurityLevel securityLevel) {
		this.securityLevel = securityLevel;
	}

	public Date getEstablishmentDate() {
		return establishmentDate;
	}

	public void setEstablishmentDate(Date establishmentDate) {
		this.establishmentDate = establishmentDate;
	}

	public Integer getCurrentPopulation() {
		return currentPopulation;
	}

	public void setCurrentPopulation(Integer currentPopulation) {
		this.currentPopulation = currentPopulation;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
