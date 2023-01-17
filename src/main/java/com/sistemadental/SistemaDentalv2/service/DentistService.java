package com.sistemadental.SistemaDentalv2.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.sistemadental.SistemaDentalv2.model.Dentist;
import com.sistemadental.SistemaDentalv2.repository.DentistRepository;

@Service
public class DentistService {

    private final DentistRepository dentistRepository;

    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public Dentist createDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    public Dentist getDentistById(Long id) {
        return dentistRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Dentista con el id " + id + " no encontrado"));
    }

    public Dentist updateDentist(Long id, Dentist updatedDentist) {
        Dentist dentist = dentistRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Dentista con el id " + id + " no encontrado"));
        dentist.setName(updatedDentist.getName());
        dentist.setEmail(updatedDentist.getEmail());
        return dentistRepository.save(dentist);
    }

    public void deleteDentist(Long id) {
        dentistRepository.deleteById(id);
    }

	public List<Dentist> getAllDentists() {
		return dentistRepository.findAll();
	}
}
