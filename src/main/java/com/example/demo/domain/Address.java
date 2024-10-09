package com.example.demo.domain;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;
    private String number;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    
    
	@ManyToOne()
	@JoinColumn(name = "imate_id")
    @JsonIgnore // Evita a serialização de imates dentro de addresses
    private Imate imate; 
	

	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "imateVisitor_id")
    @JsonIgnoreProperties("addresses") 
    @JsonIgnore // Evita a serialização de imateVisitor dentro de addresses
    private ImateVisitors imateVisitor;
     
     
    public Address() {
    }

    public Address(Integer id, String street, String number, City city, Imate imate, ImateVisitors imateVisitor) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.city = city;
		this.imate = imate;
		this.imateVisitor = imateVisitor;
	}


	// Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
        Address other = (Address) obj;
        return Objects.equals(id, other.id);
    }
}