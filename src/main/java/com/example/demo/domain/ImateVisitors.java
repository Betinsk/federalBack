package com.example.demo.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
		private Integer socialSecure;
		private String cellfoneNumber;
		
		
		@ManyToOne
	    @JoinColumn(name = "imate_id", referencedColumnName = "id")
	    private Imate imate;

		public ImateVisitors() {
			
		}
		public ImateVisitors(Integer id, String name, String age, Integer socialSecure,  String cellfoneNumber, Imate imate) {
			this.id = id;
			this.name = name;
			this.age = age;
			this.socialSecure = socialSecure;
			this.cellfoneNumber = cellfoneNumber;
			this.imate = imate;

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

		public Imate getImate() {
			return imate;
		}

		public void setImate(Imate imate) {
			this.imate = imate;
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
	                '}';
	    }
		
		
}
