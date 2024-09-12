package com.example.demo.resources;

import java.util.List;
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
		
		ImateVisitors imV= new ImateVisitors(1, "Jhon Card", "34", 84941984, "992120527", im);
		imateVisitorRepository.save(imV);
		
		return imateVisitorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ImateVisitors findById(@PathVariable Integer id) {
	    Optional<ImateVisitors> imateVisitor = imateVisitorRepository.findById(id);
	    return imateVisitor.orElse(null);
	}



	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> createVisitor(@RequestBody ImateVisitors request) {
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
	
	
	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteVisitor(@PathVariable Integer id) {
		  imateVisitorRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	   
	  }
	
	
}
