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

import com.sistemadental.SistemaDentalv2.model.Dentist;
import com.sistemadental.SistemaDentalv2.model.Patient;
import com.sistemadental.SistemaDentalv2.service.DentistService;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    private final DentistService dentistService;

    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @PostMapping
    public Dentist createDentist(@RequestBody Dentist dentist) {
        return dentistService.createDentist(dentist);
    }

    @GetMapping
    public List<Dentist> getAllDentists() {
        return dentistService.getAllDentists();
    }
    
    @GetMapping("/{id}")
    public Dentist getDentistById(@PathVariable Long id) {
        return dentistService.getDentistById(id);
    }

    @PutMapping("/{id}")
    public Dentist updateDentist(@PathVariable Long id, @RequestBody Dentist dentist) {
        return dentistService.updateDentist(id, dentist);
    }

    @DeleteMapping("/{id}")
    public void deleteDentist(@PathVariable Long id) {
        dentistService.deleteDentist(id);
    }
}

