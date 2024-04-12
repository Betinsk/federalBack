package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Imate;
import com.example.demo.domain.ImateVisitors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ImateVisitorService {

		@PersistenceContext
	    private EntityManager entityManager;

	    public void createVisitor(String nameVisitor, Imate imate) {
	  
	        // Crie uma nova instância de Parente
	        ImateVisitors visitor = new ImateVisitors();
	        visitor.setName(nameVisitor);
	      //  visitor.setImate(imate);

	        // Persista o Parente no banco de dados
	        entityManager.persist(nameVisitor);
	    }

		
	}
	

