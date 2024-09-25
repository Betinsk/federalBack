package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.City;
import com.example.demo.repository.CityRepository;

@RestController
@RequestMapping(value="/citys")
public class CityResource {

	@Autowired
	CityRepository cityRepository;
	
	@GetMapping
	public List<City> find() {
		
		
		return cityRepository.findAll();
		
	}
	
	
}
