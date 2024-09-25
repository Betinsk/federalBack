package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Address;
import com.example.demo.domain.City;
import com.example.demo.domain.Imate;
import com.example.demo.domain.State;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.ImateRepository;
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
	private ImateRepository imateRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		State st1 = new State(null, "New York");
		State st2 = new State(null, "Florida");
		
		City ct1 = new City(null, "RichVile" , st1);
		City ct2 = new City(null, "Beach" , st2);
		City ct3 = new City(null, "Miame" , st2);

		st1.getCities().addAll(Arrays.asList(ct1));
		st2.getCities().addAll(Arrays.asList(ct2, ct3));

		stateRepository.saveAll(Arrays.asList(st1,st2));
		cityRepository.saveAll(Arrays.asList(ct1,ct2, ct3));
		
		Address adr1 = new Address(null, "5th Avenue", "350", ct1);
        Address adr2 = new Address(null, "Ocean Drive", "1000" , ct2);
        Address adr3 = new Address(null, "Broadway", "123", ct1);
        Address adr4 = new Address(null, "Florida Avenue", "500",ct2);
        
        addressRepository.saveAll(Arrays.asList(adr1, adr2, adr3, adr4));
        
    	Imate imt = new Imate(1, 56, "Male", "Whiter White", 45498189);
		Imate imt2 = new Imate(2, 23, "Male", "Jessy Pinkman", 4894894);
		
		imt.getAddresses().addAll(Arrays.asList(adr1));
		imt2.getAddresses().addAll(Arrays.asList(adr2));
		
		imateRepository.saveAll(Arrays.asList(imt, imt2));

	}

}
