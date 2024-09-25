package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Address;
import com.example.demo.repository.AddressRepository;

@RestController
@RequestMapping(value="/addresses")
public class AddressResource {

	@Autowired
	AddressRepository addressRepository;
	
	@GetMapping
	public List<Address> find() {
		
		
		return addressRepository.findAll();
		
	}
	
	
}
