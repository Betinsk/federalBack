package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class State implements Serializable {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String state;
		
		@OneToMany(mappedBy = "state")
	    private List<City> cities = new ArrayList<>();
		
		
		public State() {
			
		}

		public State(Integer id, String state) {
			super();
			this.id = id;
			this.state = state;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		
		public List<City> getCities() {
			return cities;
		}

		public void setCities(List<City> cities) {
			this.cities = cities;
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
			State other = (State) obj;
			return Objects.equals(id, other.id);
		}
		
		
	
}
