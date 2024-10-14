package com.example.demo;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Address;
import com.example.demo.domain.City;
import com.example.demo.domain.Imate;
import com.example.demo.domain.ImateVisitors;
import com.example.demo.domain.Person;
import com.example.demo.domain.State;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.ImateRepository;
import com.example.demo.repository.ImateVisitorRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.StateRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	 ImateRepository imateRepository;
	
	@Autowired
	ImateVisitorRepository imateVisitorRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
 
	@Override
	public void run(String... args) throws Exception {
		
	
		
		State st1 = new State(null, "NEY MEXICO");
		State st2 = new State(null, "Florida");
		
		City ct1 = new City(null, "ALBUQUERQUE" , st1);
		City ct2 = new City(null, "Beach" , st2);
		City ct3 = new City(null, "Miame" , st2);

		st1.getCities().addAll(Arrays.asList(ct1)); 
		st2.getCities().addAll(Arrays.asList(ct2, ct3));

		stateRepository.saveAll(Arrays.asList(st1,st2));
		cityRepository.saveAll(Arrays.asList(ct1,ct2, ct3));
		
		
		Imate imt = new Imate(null,"Male", LocalDate.of(1968, 3, 15),  "Whiter White", 45498189, "Drug dealer, murderer, money laundering");
		Imate imt2 = new Imate(null,"Male", LocalDate.of(2001, 6, 23),  "Saul Godman", 4894894, "Drug dealer, murderer, money laundering");
		Imate imt3 = new Imate(null, "Fem", LocalDate.of(1969, 8, 11), "Skyler White", 488944, "Lorem Ippularised in the 1960sions of Lorem Ipsum.");

		Person person = new Person(null, "Male", LocalDate.of(1990, 5, 15), "John Doe", 123456789);


		Address adr1 = new Address(null, "5th Avenue", "350", ct1, imt, null);
        Address adr2 = new Address(null, "Ocean Drive", "1000" , ct2, imt2, null);
        Address adr3 = new Address(null, "Broadway", "123", ct1, imt, null);
        Address adr4 = new Address(null, "Florida Avenue", "500",ct2, imt3, null);
        
        ImateVisitors imV= new ImateVisitors(null, "Male", LocalDate.of(1968, 3, 15), "Saul Godman", 84941984);

        imV.setAddresses(Arrays.asList(adr1, adr2));

        
        imV.setImates(Arrays.asList(imt));
        imt.setVisitors(Arrays.asList(imV));
        adr4.setImateVisitor(imV);
        adr4.setPerson(person);
       
		imateRepository.saveAll(Arrays.asList(imt, imt2, imt3));
		
        personRepository.saveAll(Arrays.asList(person));

        addressRepository.saveAll(Arrays.asList(adr1, adr2, adr3, adr4));
        

        imateVisitorRepository.saveAll(Arrays.asList(imV));

        
        
        
     

	}

}
