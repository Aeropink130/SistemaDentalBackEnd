package com.sistemadental.SistemaDentalv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemadental.SistemaDentalv2.model.Dentist;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
}

