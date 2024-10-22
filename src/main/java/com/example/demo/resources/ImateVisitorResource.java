package com.example.demo.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ImateVisitorDto;
import com.example.demo.domain.ImateVisitors;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.ImateRepository;
import com.example.demo.repository.ImateVisitorRepository;
import com.example.demo.service.ImateVisitorService;

@RestController
@RequestMapping(value="/visitor")
public class ImateVisitorResource {
	
	@Autowired
	ImateVisitorRepository imateVisitorRepository;
	
	@Autowired
	ImateVisitorService imateVisitorService;
		
	@Autowired
	ImateRepository  imateRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@GetMapping
	public List<ImateVisitors> Listar() {
		
	
		
		return imateVisitorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ImateVisitors findById(@PathVariable Integer id) {
	    Optional<ImateVisitors> imateVisitor = imateVisitorRepository.findById(id);
	    return imateVisitor.orElse(null);
	}

	@PostMapping
	public ResponseEntity<Map<String, Object>> createImate(@RequestBody ImateVisitorDto imateVisitorDto) {
	    Map<String, Object> response = new HashMap<>();

	    try {
	        ImateVisitors imateVisitor = imateVisitorService.createVistor(imateVisitorDto);
	        response.put("message", "Visitor criado com sucesso!");
	        response.put("imateVisitor", imateVisitor); // Você pode retornar o objeto criado, se necessário
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        response.put("error", "Erro ao criar visitor: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

	
/*	@PostMapping
	public ResponseEntity<String> createVisitor(@RequestBody ImateVisitorDto request) {
        try {
   		 // Adicione logs para depurar o objeto recebido
            System.out.println("Objeto recebido: " + request.toString());
        	imateVisitorRepository.save(request);
            return ResponseEntity.ok("Parente criado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao criar parente: " + e.getMessage());
        }
    }
	*/
	
	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteVisitor(@PathVariable Integer id) {
		  imateVisitorService.deleteVisitor(id);
	        return ResponseEntity.noContent().build();
	   
	  }
	
	
}
