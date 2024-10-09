package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class ImateVisitors implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String name;
		private String age;
		private String gender;
		private Integer socialSecure;
		private String cellfoneNumber;
		
		 @ManyToMany
		 @JoinTable(
		        name = "imate_Visitors_join", // Nome da tabela de junção
		        joinColumns = @JoinColumn(name = "visitor_id"), // Chave estrangeira para Visitante
		        inverseJoinColumns = @JoinColumn(name = "imate_id")) // Chave estrangeira para Preso)
		// @JsonManagedReference
		 private List<Imate> imates = new ArrayList<>();
		
		 @OneToMany(mappedBy = "imateVisitor")
		 private List<Address> addresses = new ArrayList<>();


		public ImateVisitors() {
			
		}
		public ImateVisitors(Integer id, String name, String age, String gender, Integer socialSecure,  String cellfoneNumber) {
			this.id = id;
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.socialSecure = socialSecure;
			this.cellfoneNumber = cellfoneNumber;

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
	
		public String getCellfoneNumber() {
			return cellfoneNumber;
		}
		public void setCellfoneNumber(String cellfoneNumber) {
			this.cellfoneNumber = cellfoneNumber;
		}
		public Integer getSocialSecure() {
			return socialSecure;
		}
		public void setSocialSecure(Integer socialSecure) {
			this.socialSecure = socialSecure;
		}

		
		public List<Imate> getImates() {
			return imates;
		}
		public void setImates(List<Imate> imates) {
			this.imates = imates;
		}
		public List<Address> getAddresses() {
			return addresses;
		}
		public void setAddresses(List<Address> addresses) {
			this.addresses = addresses;
		}
		
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
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
			ImateVisitors other = (ImateVisitors) obj;
			return Objects.equals(id, other.id);
		}
	
		@Override
	    public String toString() {
	        return "ImateVisitors{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", age='" + age + '\'' +
	                ", socialSecure=" + socialSecure +
	                ", cellfoneNumber='" + cellfoneNumber + '\'' +
	                '}' + imates;
	    }
	
}
