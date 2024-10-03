package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AddressDto;
import com.example.demo.domain.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.AddressService;

@RestController
@RequestMapping(value="/addresses")
public class AddressResource {

	@Autowired
	AddressRepository addressRepository;

	 @Autowired
	 AddressService addressService;
	
	@GetMapping
	public List<Address> find() {
		
		
		return addressRepository.findAll();
		
	}
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Address> findById(@PathVariable Integer id) {
	        Address address = addressService.findById(id);
	        return ResponseEntity.ok().body(address);
	    }
	
	@PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody AddressDto addressDTO) {
        Address address = addressService.createAddress(addressDTO);
        return ResponseEntity.ok(address);
    }
	
	
	
}
