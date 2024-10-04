package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ImateDto;
import com.example.demo.domain.Imate;
import com.example.demo.repository.ImateRepository;
import com.example.demo.resources.exceptions.ErrorResponse;
import com.example.demo.service.ImateService;

@RestController
@RequestMapping(value="/imates")
public class ImateResource {
	
	@Autowired
	 ImateService imateService;
	
	@Autowired
	 ImateRepository imateRepository;


	
	@GetMapping
		public List<Imate> Listar() {
	

		return imateRepository.findAll();
	}
	
		@GetMapping("/{id}")
	    public ResponseEntity<Imate> findById(@PathVariable Integer id) {
	        Imate optionalImate = imateService.find(id);
			return ResponseEntity.ok().body(optionalImate);
	    }
		
		@PostMapping
	    public ResponseEntity<String> createImate(@RequestBody ImateDto imateDto) {
			  try {
			Imate imate = imateService.createImate(imateDto);
			
            return ResponseEntity.ok("Imate criado com sucesso!");
        } catch (Exception e) {

        	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("Erro ao criar imate: " + e.getMessage());
        }
    }
	 

	/*	@PostMapping
	    public ResponseEntity<Imate> createImate(@RequestBody Imate imate) {
	        try {
	        	Imate savedImate = imateRepository.save(imate);
	            return new ResponseEntity<>(savedImate, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    */
	
		
		
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

