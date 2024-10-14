package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ImateVisitorDto;
import com.example.demo.domain.Address;
import com.example.demo.domain.ImateVisitors;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.ImateVisitorRepository;

import jakarta.transaction.Transactional;

@Service
public class ImateVisitorService {

		@Autowired
		AddressService addressService;
		

	    @Autowired
	    private AddressRepository addressRepository;	
		
		@Autowired
		ImateVisitorRepository imateVisitorRepository;
	
	 @Transactional
		public ImateVisitors createVistor(ImateVisitorDto imateVisitorDto) {
			
			System.out.print(imateVisitorDto);

		 	ImateVisitors imateVisitor = new ImateVisitors();
			
			Address address = addressService.createAddress(imateVisitorDto.getAddressDto());
			
			System.out.print(imateVisitorDto.getAddressDto());

			// Criar uma lista de endereços (mesmo que seja apenas um)
		    List<Address> addresses = new ArrayList<>();
		    addresses.add(address);

			//System.out.print(address);

		    // Associar a lista de endereços ao Imate
		    imateVisitor.setAddresses(addresses);
			
		  //  imateVisitor.setDateOfBirth(imateVisitorDto.getAge());
		    imateVisitor.setGender(imateVisitorDto.getGender());
		    imateVisitor.setName(imateVisitorDto.getName());
		    imateVisitor.setSocialSecurity(imateVisitorDto.getSocialSecure());
		//    imateVisitor.setCellfoneNumber(imateVisitorDto.getCellfoneNumber());
		    imateVisitor.setImates(imateVisitorDto.getImates());
			
			address.setImateVisitor(imateVisitor);
			
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
	

