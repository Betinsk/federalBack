package com.example.demo.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		public ResponseEntity<Map<String, Object>> createImate(@RequestBody ImateDto imateDto) {
		    Map<String, Object> response = new HashMap<>();
		    try {
		        Imate imate = imateService.createImate(imateDto);
		        response.put("message", "Imate criado com sucesso!");
		        response.put("imate", imate); // Você pode retornar o objeto criado, se necessário
		        return ResponseEntity.ok(response);
		    } catch (Exception e) {
		        response.put("error", "Erro ao criar imate: " + e.getMessage());
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
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

