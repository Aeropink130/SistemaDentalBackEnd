package com.sistemadental.SistemaDentalv2.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.sistemadental.SistemaDentalv2.model.User;
import com.sistemadental.SistemaDentalv2.repository.DentistRepository;
import com.sistemadental.SistemaDentalv2.repository.PatientRepository;
import com.sistemadental.SistemaDentalv2.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final DentistRepository dentistRepository;
    private final PatientRepository patientRepository;

    public UserService(UserRepository userRepository, DentistRepository dentistRepository, PatientRepository patientRepository) {
        this.userRepository = userRepository;
        this.dentistRepository = dentistRepository;
        this.patientRepository = patientRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
    }

    public User updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setType(updatedUser.getType());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

	public DentistRepository getDentistRepository() {
		return dentistRepository;
	}

	public PatientRepository getPatientRepository() {
		return patientRepository;
	}
}

