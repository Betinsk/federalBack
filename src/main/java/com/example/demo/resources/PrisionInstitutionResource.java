package com.example.demo.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Address;
import com.example.demo.domain.City;
import com.example.demo.domain.PrisionalInstitution;
import com.example.demo.domain.State;
import com.example.demo.enums.SecurityLevel;

@RestController
@RequestMapping(value="/prisions")
public class PrisionInstitutionResource {

	@GetMapping
	public  List<PrisionalInstitution> listar() {
        List<PrisionalInstitution> prisions = new ArrayList<>();

        // Criando estados
     	State nm = new State(null, "New Mexico");
     	State tx = new State(null, "Texas");

        City city1 = new City(null, "San Francisco", nm);
        City city2 = new City(null, "San Quentin",tx);
        City city3 = new City(null, "Folsom", nm);

        // Criando os endereços associados às cidades
        Address address1 = new Address(null, "123 Island Rd", "1", city1, null, null);
        Address address2 = new Address(null,"San Quentin Rd", "2", city2, null, null);
        Address address3 = new Address(null,"300 Prison Rd", "3", city3, null, null);
        
        // Instanciando as prisões
        prisions.add(new PrisionalInstitution("Alcatraz", SecurityLevel.HIGH, new Date(1940, 1, 1), 100, 200, "Famous high-security prison.", address1));
        prisions.add(new PrisionalInstitution("San Quentin", SecurityLevel.MEDIUM, new Date(1852, 7, 1), 1500, 3000, "California state prison for men.", address2));
        prisions.add(new PrisionalInstitution("Folsom", SecurityLevel.HIGH, new Date(1880, 1, 1), 1200, 2500, "Prison located in California, famous for Johnny Cash's performance.", address3));

        
        
         return prisions;
    }
	
	
}
