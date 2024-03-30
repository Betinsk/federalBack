package com.toDoList.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String category;
	  /*  private String description; 
	    
	    @OneToMany(mappedBy="category")
	    private List<Task> Task = new ArrayList<>();
*/
	    
	    public Category() {
	    	
	    }
	    
		public Category(Long id, String category) {
			super();
			this.id = id;
			this.setCategory(category);
		//	this.setDescription(description);
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		
	/*	public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
*/
		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

	
	
		
	    
	    

	 
	}


