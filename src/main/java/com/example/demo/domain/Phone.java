package com.example.demo.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String number;

    @ManyToOne
    @JoinColumn(name = "person_id")  // Chave estrangeira
    private Person person;
    
    @ManyToOne
    @JoinColumn(name = "imate_id")  // Chave estrangeira
    private Imate imate;

    
    @ManyToOne
    @JoinColumn(name = "imateVisitor_id")  // Chave estrangeira
    private ImateVisitors imateVisitor;


    // Construtores, getters e setters
    public Phone() {}
    

	public Phone(Integer id, String number, Person person, Imate imate, ImateVisitors imateVisitor) {
		super();
		this.id = id;
		this.number = number;
		this.person = person;
		this.imate = imate;
		this.imateVisitor = imateVisitor;
	}


	public Imate getImate() {
		return imate;
	}


	public void setImate(Imate imate) {
		this.imate = imate;
	}


	public ImateVisitors getImateVisitor() {
		return imateVisitor;
	}



	public void setImateVisitor(ImateVisitors imateVisitor) {
		this.imateVisitor = imateVisitor;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }
    

    public void setNumber(String number) {
        this.number = number;
    }

 
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

