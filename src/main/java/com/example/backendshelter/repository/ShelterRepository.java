package com.example.backendshelter.repository;

import com.example.backendshelter.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShelterRepository extends JpaRepository<Shelter, Long> {
}
