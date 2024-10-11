package com.example.demo.DTO;

import java.time.LocalDate;

public class ImateDto {
	
	private LocalDate dateOfBirth;
	private String gender;
	private String imateName;
	private Integer socialSecurity;
	private String commitedCrime;
	
	AddressDto addressDto;
	
	ImateDto() {
		
	}

	

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return imateName;
	}

	public void setName(String imateName) {
		this.imateName = imateName;
	}

	public Integer getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(Integer socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

	@Override
	public String toString() {
		return "ImateDto [age=" + dateOfBirth + ", gender=" + gender + ", imateName=" + imateName + ", socialSecurity=" + socialSecurity
				+ ", addressDto=" + addressDto + "]";
	}

	public String getCommitedCrime() {
		return commitedCrime;
	}

	public void setCommitedCrime(String commitedCrime) {
		this.commitedCrime = commitedCrime;
	}
	
	
	

}
