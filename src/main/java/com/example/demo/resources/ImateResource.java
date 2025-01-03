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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public ResponseEntity<List<Imate>> listar() {
	    try {
	        List<Imate> imates = imateRepository.findAll();
	        // Verifica se a lista está vazia e retorna 204 (No Content) se não houver registros
	        if (imates.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }
	        // Retorna a lista de imates com o status 200 (OK)
	        return ResponseEntity.ok(imates);
	    } catch (Exception e) {
	        // Em caso de erro, retorna 500 (Internal Server Error)
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	
		@GetMapping("/{id}")
	    public ResponseEntity<Imate> findById(@PathVariable Integer id) {
	        Imate optionalImate = imateService.find(id);
			return ResponseEntity.ok().body(optionalImate);
	    }
		
	    @GetMapping("/ssn/{socialSecurity}")
	    public ResponseEntity<Imate> findBySocialSecurity(@PathVariable Integer socialSecurity) {
	        Imate optionalImate = imateService.findBySocialSecurity(socialSecurity);
			return ResponseEntity.ok().body(optionalImate);
	    }
		
		@PostMapping
		public ResponseEntity<Map<String, Object>> createImate(@RequestBody ImateDto imateDto) {
		    Map<String, Object> response = new HashMap<>();
            System.out.println("Objeto recebido: " + imateDto.toString());

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
		    public ResponseEntity<Imate> updateInmate(@PathVariable Integer id, @RequestBody ImateDto inmateDto) {
		        Imate updatedImate = imateService.updateInmate(id, inmateDto);
		        return ResponseEntity.ok(updatedImate);
		    }
		
		  @DeleteMapping("/{id}")
		    public ResponseEntity<Void> deleteImate(@PathVariable Integer id) {
			  imateRepository.deleteById(id);
		        return ResponseEntity.noContent().build();
		   
		  }
		  
			//TEST DA IMAGEM NO BUCKET
			@PostMapping("/upload")
			public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile file) {
			    String fileUrl = imateService.uploadImg(file);
			    if (fileUrl != null) {
			        return ResponseEntity.ok("Arquivo enviado com sucesso: " + fileUrl);
			    } else {
			        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao enviar arquivo.");
			    }
			}


}

