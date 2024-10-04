package com.example.demo.DTO;

public class AddressDto {

		private String street;
	    private String number;
	    private String cityName; // Nome da cidade a ser criada
	    private String stateName; // Nome do estado a ser criado
	
	    public AddressDto () {
	    	
	    }

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getCityName() {
			return cityName;
		}

		public void setCityName(String cityName) {
			this.cityName = cityName;
		}

		public String getStateName() {
			return stateName;
		}

		public void setStateName(String stateName) {
			this.stateName = stateName;
		}

		@Override
		public String toString() {
			return "street=" + street + ", number=" + number + ", cityName=" + cityName + ", stateName="
					+ stateName;
		}
	    
	    
	    
}
