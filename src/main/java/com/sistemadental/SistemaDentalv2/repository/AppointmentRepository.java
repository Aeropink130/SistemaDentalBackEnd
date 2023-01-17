package com.sistemadental.SistemaDentalv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadental.SistemaDentalv2.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
