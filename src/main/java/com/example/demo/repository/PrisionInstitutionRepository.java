package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.PrisionalInstitution;

@Repository
public interface PrisionInstitutionRepository extends JpaRepository<PrisionalInstitution, Integer> {



	
}
