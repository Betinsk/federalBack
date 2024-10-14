package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class ImateVisitors extends Person implements Serializable {

	private static final long serialVersionUID = 1L;

		
		 @ManyToMany
		 @JoinTable(
		        name = "imate_Visitors_join", // Nome da tabela de junção
		        joinColumns = @JoinColumn(name = "visitor_id"), // Chave estrangeira para Visitante
		        inverseJoinColumns = @JoinColumn(name = "imate_id")) // Chave estrangeira para Preso)
		// @JsonManagedReference
		 private List<Imate> imates = new ArrayList<>();
		
	/*	 @OneToMany(mappedBy = "imateVisitor",  cascade = CascadeType.REMOVE, orphanRemoval = true)
		 private List<Address> addresses = new ArrayList<>();

		 */

		public ImateVisitors() {
			 
		}
		
		
		
		public ImateVisitors(Integer id, String gender, LocalDate dateOfBirth, String name, Integer socialSecurity
			) {
		super(id, gender, dateOfBirth, name, socialSecurity);
	
	}



		public List<Imate> getImates() {
			return imates;
		}



		public void setImates(List<Imate> imates) {
			this.imates = imates;
		}



	
	
}
