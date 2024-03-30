package com.example.demo.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/imates")
public class ImateResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String Listar() {
		return "REST ESTÁ FUNCIONANDO";
	}
	
}
