package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.ImateVisitors;

@Repository
public interface ImateVisitorRepository extends JpaRepository<ImateVisitors, Integer> {

	
}
