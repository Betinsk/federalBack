package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.City;
import com.example.demo.domain.State;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.StateRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		State st1 = new State(null, "New York");
		State st2 = new State(null, "Florida");
		
		City ct1 = new City(null, "RichVile" , st1);
		City ct2 = new City(null, "Florida" , st2);
		City ct3 = new City(null, "Miame" , st2);

		
		st1.getCities().addAll(Arrays.asList(ct1));
		st2.getCities().addAll(Arrays.asList(ct2, ct3));

		
		stateRepository.saveAll(Arrays.asList(st1,st2));
		cityRepository.saveAll(Arrays.asList(ct1,ct2, ct3));

	}

}
