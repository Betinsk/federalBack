package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.State;
import com.example.demo.repository.StateRepository;

@RestController
@RequestMapping(value="/states")
public class StateResource {

	@Autowired
	StateRepository stateRepository;
	
	@GetMapping
	public List<State> find() {
		
		
		return stateRepository.findAll();
		
	}
	
	
}
