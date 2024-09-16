package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Imate;
import com.example.demo.repository.ImateRepository;
import com.example.demo.service.execption.ObjectNotFoundException;

@Service
public class ImateService {
	
	@Autowired
	private ImateRepository imateRepository;
	
	
	
	public Imate find(Integer id) {
		Optional<Imate> objImate = imateRepository.findById(id);
		return objImate.orElseThrow(() -> new ObjectNotFoundException("Objeto com ID " + id + " não encontrado."+ " ,tipo"+ Imate.class.getName()));
		
	}
	
	
}
