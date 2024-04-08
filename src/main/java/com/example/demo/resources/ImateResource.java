package com.example.demo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Imate;
import com.example.demo.repository.ImateRepository;

@RestController
@RequestMapping(value="/imates")
public class ImateResource {
	
	@Autowired
	ImateRepository imateRepository;
	
	@RequestMapping(method=RequestMethod.GET)
		public List<Imate> Listar() {
		
		Imate imt = new Imate(1, 56, "Male", "Whiter White", 45498189);
		Imate imt2 = new Imate(2, 23, "Male", "Jessy Pinkman", 4894894);
		List<Imate> list = new ArrayList<>();
		
		imateRepository.save(imt);
		imateRepository.save(imt2);

		return imateRepository.findAll();
	}
	

		@RequestMapping(method=RequestMethod.POST)
	    public ResponseEntity<Imate> createImate(@RequestBody Imate imate) {
	        try {
	        	Imate savedImate = imateRepository.save(imate);
	            return new ResponseEntity<>(savedImate, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
		
		 @PutMapping("/{id}")
		    public ResponseEntity<Imate> updateImate(@PathVariable Integer id, @RequestBody Imate updatedImate) {
		        try {
		            Imate updated = imateRepository.save(updatedImate);
		            return ResponseEntity.ok(updated);
		        } catch (IllegalArgumentException e) {
		            return ResponseEntity.notFound().build();
		        }
		    }
		
		  @DeleteMapping("/{id}")
		    public ResponseEntity<Void> deleteImate(@PathVariable Integer id) {
			  imateRepository.deleteById(id);
		        return ResponseEntity.noContent().build();
		   
		  }
		  

}

