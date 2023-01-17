package com.sistemadental.SistemaDentalv2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadental.SistemaDentalv2.model.Appointment;
import com.sistemadental.SistemaDentalv2.service.AppointmentService;



@RestController
	@RequestMapping("/appointments")
	public class AppointmentController {
	
	private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    
    	//Metodo POST para crear una nueva cita
	    @PostMapping
	    public void createAppointment(@RequestBody Appointment appointment) {
	        appointmentService.createAppointment(appointment);	    }

	    //Metodo GET para mostrar todas las citas
	    @GetMapping
	    public List<Appointment> getAllAppointments() {
	        return appointmentService.getAllAppointments();	    }

	    //Metodo GET para mostrar una cita por id
	    @GetMapping("/{id}")
	    public Appointment getAppointmentById(@PathVariable Long id) {
	        return appointmentService.getAppointmentById(id);
	    }

	    //Metodo PUT para actualizar una cita por ID
	    @PutMapping("/{id}")
	    public void updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
	        appointmentService.updateAppointment(id, appointment);
	    }

	    
	    //Metodo DELETE para borrar una cita por ID
	    @DeleteMapping("/{id}")
	    public void deleteAppointment(@PathVariable Long id) {
	        appointmentService.deleteAppointment(id);
	    }
	}

