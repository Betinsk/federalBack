package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.AddressDto;
import com.example.demo.domain.Address;
import com.example.demo.domain.City;
import com.example.demo.domain.State;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.StateRepository;

@Service
public class AddressService {

	
	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	  public Address findById(Integer id) {
	        Optional<Address> obj = addressRepository.findById(id);
	        return obj.orElseThrow(() -> new RuntimeException("Address not found for id: " + id));
	    }
	
	 public Address createAddress(AddressDto addressDTO) {
		 
		 
	        // Busca ou cria o estado
	        State state = stateRepository.findByState(addressDTO.getStateName())
	            .orElseGet(() -> {
	                State newState = new State();
	                newState.setState(addressDTO.getStateName());
	                return stateRepository.save(newState);
	            });

	        // Busca ou cria a cidade
	        City city = cityRepository.findByCityAndStateId(addressDTO.getCityName(), state.getId())
	            .orElseGet(() -> {
	                City newCity = new City();
	                newCity.setCity(addressDTO.getCityName());
	                newCity.setState(state);
	                return cityRepository.save(newCity);
	            });

	        // Cria o endereço
	        Address address = new Address();
	        address.setStreet(addressDTO.getStreet());
	        address.setNumber(addressDTO.getNumber());
	        address.setCity(city);
	        

	        return addressRepository.save(address);
	    }
	 
	
	 public Address updateAddress(Integer id, AddressDto addressDTO) {
		    // Busca o endereço pelo ID
		    Address address = addressRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

		    // Atualiza os dados do endereço
		    address.setStreet(addressDTO.getStreet());
		    address.setNumber(addressDTO.getNumber());
		   
		    // Busca ou cria o estado
	        State state = stateRepository.findByState(addressDTO.getStateName())
	            .orElseGet(() -> {
	                State newState = new State();
	                newState.setState(addressDTO.getStateName());
	                return stateRepository.save(newState);
	            });

	        // Busca ou cria a cidade
	        City city = cityRepository.findByCityAndStateId(addressDTO.getCityName(), state.getId())
	            .orElseGet(() -> {
	                City newCity = new City();
	                newCity.setCity(addressDTO.getCityName());
	                newCity.setState(state);
	                return cityRepository.save(newCity);
	            });
		       
		    address.setCity(city);

		    
		    return addressRepository.save(address);
		}

	 
	 
	}
	

