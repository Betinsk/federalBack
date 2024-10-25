package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Phone;
import com.example.demo.repository.PhoneRepository;
import com.example.demo.service.PhoneService;

@RestController
@RequestMapping(value="/phones")
public class PhoneResource {

	@Autowired
	PhoneRepository phoneRepository;

	 @Autowired
	 PhoneService phoneService;
	
	@GetMapping
	public List<Phone> find() {
		
		
		return phoneRepository.findAll();
		
	}
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Phone> findById(@PathVariable Integer id) {
	        Phone phones = phoneService.findById(id);
	        return ResponseEntity.ok().body(phones);
	    }
	
	@PostMapping
    public ResponseEntity<Phone> createPhone(@RequestBody Phone phone) {
        Phone address = phoneRepository.save(phone);
        return ResponseEntity.ok(address);
    }
	
	
	
	@PutMapping("/{id}")
    public ResponseEntity<Phone> updatePhone(
            @PathVariable Integer id, 
            @RequestBody Phone phone) {
        Phone updatedPhone = phoneService.updatePhone(id, phone);
        return ResponseEntity.ok(updatedPhone);
    }
    
	
	
}
