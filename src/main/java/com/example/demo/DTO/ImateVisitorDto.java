package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.Imate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ImateVisitorDto {
	
	private Integer id;
    private String name;
    private String age;
    private String gender;
    private Integer socialSecure;
    private String cellfoneNumber;

    private List<Imate> imates = new ArrayList<>();
    
    @JsonIgnoreProperties("cities") 
	AddressDto addressDTO;
	
	public ImateVisitorDto() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Integer getSocialSecure() {
		return socialSecure;
	}

	public void setSocialSecure(Integer socialSecure) {
		this.socialSecure = socialSecure;
	}

	public String getCellfoneNumber() {
		return cellfoneNumber;
	}

	public void setCellfoneNumber(String cellfoneNumber) {
		this.cellfoneNumber = cellfoneNumber;
	}

	public AddressDto getAddressDto() {
		return addressDTO;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDTO = addressDto;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}



	@Override
	public String toString() {
		return "ImateVisitorDto [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", socialSecure=" + socialSecure + ", cellfoneNumber=" + cellfoneNumber + ", imates=" + imates
				+ ", addressDto=" + addressDTO + "]";
	}

	public List<Imate> getImates() {
		return imates;
	}

	public void setImates(List<Imate> imates) {
		this.imates = imates;
	}

	
	
	
    
}
