package com.example.demo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Imate;

@RestController
@RequestMapping(value="/imates")
public class ImateResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Imate> Listar() {
		
		Imate imt = new Imate(1, 56, "Male", "Whiter White");
		Imate imt2 = new Imate(2, 23, "Male", "Jessy Pinkman");
		List<Imate> list = new ArrayList<>();
		
		list.add(imt);
		list.add(imt2);

		return list;
	}
	
}
