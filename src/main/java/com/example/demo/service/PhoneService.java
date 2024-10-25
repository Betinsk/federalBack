package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Phone;
import com.example.demo.repository.PhoneRepository;

@Service
public class PhoneService {

	@Autowired
	PhoneRepository phoneRepository;
	
	  public Phone findById(Integer id) {
	        Optional<Phone> obj = phoneRepository.findById(id);
	        return obj.orElseThrow(() -> new RuntimeException("Phone not found for id: " + id));
	    }

	public Phone updatePhone(Integer id, Phone phone) {
		Phone phones = phoneRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Phone not found for id: " + id));
		
		phones.setNumber(phone.getNumber());
		return phoneRepository.save(phones);
		
	}
	
	

	 
	 
	}
	

