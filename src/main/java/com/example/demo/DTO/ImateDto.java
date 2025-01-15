package com.example.demo.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Phone;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ImateDto {
	
	private LocalDate dateOfBirth;
	private String gender;
	private String imateName;
	private Integer socialSecurity;
	private String commitedCrime;

	
	private List<Phone> phones = new ArrayList<>();
	
	 @JsonIgnoreProperties("cities") 
	    private List<AddressDto> addressDto = new ArrayList<>(); // Certifique-se de que isso seja uma lista se você estiver enviando um array
	
	 private List<MultipartFile> imageUrls = new ArrayList<>();
	 
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

	
	

	public String getImateName() {
		return imateName;
	}

	public void setImateName(String imateName) {
		this.imateName = imateName;
	}

	public List<AddressDto> getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(List<AddressDto> addressDto) {
		this.addressDto = addressDto;
	}

	@Override
	public String toString() {
		return "ImateDto [dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", imateName=" + imateName + ", socialSecurity=" + socialSecurity
				+ ", addressDto=" + addressDto + "]" + "Phones " + phones;
	}

	public String getCommitedCrime() {
		return commitedCrime;
	}

	public void setCommitedCrime(String commitedCrime) {
		this.commitedCrime = commitedCrime;
	}



	public List<Phone> getPhones() {
		return phones;
	}



	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<MultipartFile> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(List<MultipartFile> imageUrls) {
		this.imageUrls = imageUrls;
	}
	
	
	

}
