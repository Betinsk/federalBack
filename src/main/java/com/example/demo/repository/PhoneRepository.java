package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

}
