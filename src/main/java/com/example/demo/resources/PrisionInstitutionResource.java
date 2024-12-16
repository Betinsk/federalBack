package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.PrisionalInstitution;
import com.example.demo.repository.PrisonInstitutionRepository;

@RestController
@RequestMapping(value="/prisions")
public class PrisionInstitutionResource {

	@Autowired
	PrisonInstitutionRepository prisonInstitutionRepository;
		
	
	@GetMapping
	public  List<PrisionalInstitution> listar() {

       
		return prisonInstitutionRepository.findAll();

    }
	
	
}
