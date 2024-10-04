package com.example.demo.DTO;

public class ImateDto {
	
	private Integer age;
	private String gender;
	private String name;
	private Integer socialSecurity;
	private String commitedCrime;
	
	AddressDto addressDto;
	
	ImateDto() {
		
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

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

	@Override
	public String toString() {
		return "ImateDto [age=" + age + ", gender=" + gender + ", name=" + name + ", socialSecurity=" + socialSecurity
				+ ", addressDto=" + addressDto + "]";
	}

	public String getCommitedCrime() {
		return commitedCrime;
	}

	public void setCommitedCrime(String commitedCrime) {
		this.commitedCrime = commitedCrime;
	}
	
	
	

}
