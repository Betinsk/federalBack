package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Imate;
import com.example.demo.domain.ImateVisitors;
import com.example.demo.repository.imateVisitorRepository;
import com.example.demo.service.ImateVisitorService;

@RestController
@RequestMapping(value="/visitor")
public class imateVisitorResource {
	
	@Autowired
	imateVisitorRepository imateVisitorRepository;
	
	@Autowired
	ImateVisitorService imateVisitorService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ImateVisitors> Listar() {
		
		Imate im = new Imate(1, 54, "Male", "Jack Lane", 488944);
		
		ImateVisitors imV= new ImateVisitors(1, "Jhon Card", im);
		imateVisitorRepository.save(imV);
		
		return imateVisitorRepository.findAll();
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createVisitor(@RequestBody ImateVisitors request) {
        try {
        	imateVisitorService.createVisitor(request);
            return ResponseEntity.ok("Parente criado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao criar parente: " + e.getMessage());
        }
    }
	
	
	
}
