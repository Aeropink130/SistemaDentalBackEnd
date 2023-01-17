package com.sistemadental.SistemaDentalv2.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadental.SistemaDentalv2.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
