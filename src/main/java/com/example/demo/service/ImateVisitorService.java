package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.AddressDto;
import com.example.demo.DTO.ImateVisitorDto;
import com.example.demo.domain.Address;
import com.example.demo.domain.ImateVisitors;
import com.example.demo.domain.Phone;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.ImateVisitorRepository;
import com.example.demo.repository.PhoneRepository;

import jakarta.transaction.Transactional;

@Service
public class ImateVisitorService {

		@Autowired
		AddressService addressService;
		

	    @Autowired
	    private AddressRepository addressRepository;	
		
		@Autowired
		ImateVisitorRepository imateVisitorRepository;
		
		@Autowired
		PhoneRepository phoneRepository;
	
		@Transactional
		public ImateVisitors createVistor(ImateVisitorDto imateVisitorDto) {
			
		 	ImateVisitors imateVisitor = new ImateVisitors();
		 	
		 	 // Percorrer a lista de endereços
		    List<AddressDto> addressList = imateVisitorDto.getAddressDto(); // Obter a lista de endereços
	        List<Address> addresses = new ArrayList<>();

		    for (AddressDto addressDto : addressList) {
		        // Criar o objeto Address a partir do AddressDto
		        Address address = addressService.createAddress(addressDto);
				address.setImateVisitor(imateVisitor);
			    addresses.add(address);

		        }
			//Address address = addressService.createAddress(imateVisitorDto.getAddressDTO());
			
			System.out.print(imateVisitorDto.getAddressDto());

			// Criar uma lista de endereços (mesmo que seja apenas um)
		   

			List<Phone> phones = imateVisitorDto.getPhones();
		    phones.forEach(phone -> phone.setImateVisitor(imateVisitor));


			 // Salvar a lista de telefones e associá-la ao Imate
			     phoneRepository.saveAll(phones);
			     imateVisitor.setPhones(phones);

		    // Associar a lista de endereços ao Imate
		    imateVisitor.setAddresses(addresses);
			
		    imateVisitor.setDateOfBirth(imateVisitorDto.getDateOfBirth());
		    imateVisitor.setGender(imateVisitorDto.getGender());
		    imateVisitor.setName(imateVisitorDto.getName());
		    imateVisitor.setSocialSecurity(imateVisitorDto.getSocialSecurity());
		    imateVisitor.setImates(imateVisitorDto.getImates());
			
			
		//	System.out.print(imate);

		    // Salvar o Imate (exemplo de como salvar, depende da sua lógica)
		    return imateVisitorRepository.save(imateVisitor);
			
		}
	 
	 
	 public void deleteVisitor(Integer id) {
	        // Primeiro, remova os endereços associados
	        List<Address> addresses = addressRepository.findByImateVisitorId(id);
	        for (Address address : addresses) {
	            addressRepository.delete(address);
	        }
	        
	        // Remova o visitante
	        imateVisitorRepository.deleteById(id);
	    }
		
	}
	

