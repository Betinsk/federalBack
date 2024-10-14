package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	//Metodo para buscar os endeereços do imate pelo id 
	List<Address> findByImateVisitorId(Integer id);

	
}
