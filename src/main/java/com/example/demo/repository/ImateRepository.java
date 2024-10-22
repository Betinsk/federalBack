package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Imate;

@Repository
public interface ImateRepository extends JpaRepository<Imate, Integer> {
	
    Optional<Imate> findBySocialSecurity(Integer socialSecurity);


}
