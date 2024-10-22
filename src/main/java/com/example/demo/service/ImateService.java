package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ImateDto;
import com.example.demo.domain.Address;
import com.example.demo.domain.Imate;
import com.example.demo.domain.Phone;
import com.example.demo.domain.State;
import com.example.demo.repository.ImateRepository;
import com.example.demo.repository.PhoneRepository;
import com.example.demo.service.execption.ObjectNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ImateService {
	
	@Autowired
	private ImateRepository imateRepository;
	
	@Autowired
	private  AddressService addressService; // <-- Estava dando um erro de adressService nulo, porque estava static essa instancia 
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	
	public Imate find(Integer id) {
		Optional<Imate> objImate = imateRepository.findById(id);
		return objImate.orElseThrow(() -> new ObjectNotFoundException("Objeto com ID " + id + " não encontrado."+ " ,tipo"+ Imate.class.getName()));
		
	}
	
	public Imate findBySocialSecurity(Integer socialSecurity) {
		Optional<Imate> objImate = imateRepository.findBySocialSecurity(socialSecurity);
		return objImate.orElseThrow(() -> new ObjectNotFoundException("Objeto com Social Security " + socialSecurity + " não encontrado."+ " ,tipo"+ Imate.class.getName()));
		
	}
	


    @Transactional
	public Imate createImate(ImateDto imateDto) {
		
    	  // Verifica se já existe um Imate com o mesmo socialSecurity
        Optional<Imate> existingImate = imateRepository.findBySocialSecurity(imateDto.getSocialSecurity()); 

        if (existingImate.isPresent()) {
            throw new IllegalArgumentException("An Imate with the same Social Security already exists.");
        }

    	
        // Criar uma nova instância de Imate
		Imate imate = new Imate();
		
		// Criar endereço a partir do DTO e associá-lo ao Imate
		Address address = addressService.createAddress(imateDto.getAddressDto());
		
		// Salvar os telefones e associá-los ao Imate
	    List<Phone> phones = imateDto.getPhones();
	 // Associar cada telefone ao Imate
	    phones.forEach(phone -> phone.setImate(imate));
	    
		// Criar uma lista de endereços (mesmo que seja apenas um)
	    List<Address> addresses = new ArrayList<>();
	    addresses.add(address);

	 // Salvar a lista de telefones e associá-la ao Imate
	     phoneRepository.saveAll(phones);
	    imate.setPhones(phones);

		//System.out.print(address); 

	    // Associar a lista de endereços ao Imate
	    imate.setAddresses(addresses);
		
		imate.setDateOfBirth(imateDto.getDateOfBirth());
		imate.setGender(imateDto.getGender());
		imate.setName(imateDto.getName());
		imate.setPhones(imateDto.getPhones());
		imate.setSocialSecurity(imateDto.getSocialSecurity());
		imate.setCommitedCrime(imateDto.getCommitedCrime());
		
		address.setImate(imate);
		
	//	System.out.print(imate);

	    // Salvar o Imate (exemplo de como salvar, depende da sua lógica)
	    return imateRepository.save(imate);
		
	}
	
	
}
