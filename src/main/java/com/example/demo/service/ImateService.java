package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ImateDto;
import com.example.demo.domain.Address;
import com.example.demo.domain.Imate;
import com.example.demo.repository.ImateRepository;
import com.example.demo.service.execption.ObjectNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ImateService {
	
	@Autowired
	private ImateRepository imateRepository;
	
	@Autowired
	private  AddressService addressService; // <-- Estava dando um erro de adressService nulo, porque estava static essa instancia 
	
	
	public Imate find(Integer id) {
		Optional<Imate> objImate = imateRepository.findById(id);
		return objImate.orElseThrow(() -> new ObjectNotFoundException("Objeto com ID " + id + " não encontrado."+ " ,tipo"+ Imate.class.getName()));
		
	}


    @Transactional
	public Imate createImate(ImateDto imateDto) {
		
		//System.out.print(imateDto);

		Imate imate = new Imate();
		
		Address address = addressService.createAddress(imateDto.getAddressDto());
		
		System.out.print(imateDto.getAddressDto());

		// Criar uma lista de endereços (mesmo que seja apenas um)
	    List<Address> addresses = new ArrayList<>();
	    addresses.add(address);

		//System.out.print(address);

	    // Associar a lista de endereços ao Imate
	    imate.setAddresses(addresses);
		
		imate.setAge(imateDto.getAge());
		imate.setGender(imateDto.getGender());
		imate.setName(imateDto.getName());
		imate.setSocialSecurity(imateDto.getSocialSecurity());
		imate.setCommitedCrime(imateDto.getCommitedCrime());
		
		address.setImate(imate);
		
	//	System.out.print(imate);

	    // Salvar o Imate (exemplo de como salvar, depende da sua lógica)
	    return imateRepository.save(imate);
		
	}
	
	
}
