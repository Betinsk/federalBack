package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

    Optional<State> findByState(String state);
    
}
