package com.sistemadental.SistemaDentalv2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemadental.SistemaDentalv2.model.Appointment;
import com.sistemadental.SistemaDentalv2.repository.AppointmentRepository;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    
    //Crear cita
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    //Obtener citas
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    //Obtener cita por ID
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    //Actualizar cita por ID
    public Appointment updateAppointment(Long id, Appointment appointment) {
        appointment.setId(id);
        return appointmentRepository.save(appointment);
    }

    //Borrar cita por id
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
