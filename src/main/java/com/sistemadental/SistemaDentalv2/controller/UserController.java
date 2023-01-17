package com.sistemadental.SistemaDentalv2.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistemadental.SistemaDentalv2.model.Dentist;
import com.sistemadental.SistemaDentalv2.model.Patient;
import com.sistemadental.SistemaDentalv2.model.User;
import com.sistemadental.SistemaDentalv2.model.UserType;
import com.sistemadental.SistemaDentalv2.service.UserService;
import com.sistemadental.SistemaDentalv2.repository.DentistRepository;
import com.sistemadental.SistemaDentalv2.repository.PatientRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;
	private CrudRepository<Dentist, Long> dentistRepository;
	private CrudRepository<Dentist, Long> patientRepository;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @SuppressWarnings("unchecked")
	@PostMapping("/register")
    public Dentist register(@RequestBody User user) {
        // Verifica el tipo de usuario
        if (user.getType() == UserType.DENTIST) {
            // Crea un nuevo dentista
            Dentist dentist = new Dentist();
            dentist.setName(user.getName());
            dentist.setEmail(user.getEmail());
            return dentistRepository.save(dentist);
        } else if (user.getType()==UserType.PATIENT) {
            // Crea un nuevo paciente
            Patient patient = new Patient();
            patient.setName(user.getName());
            patient.setEmail(user.getEmail());
            return patientRepository.saveAll((Iterable<S>) patient);
        } else {
            // Si el tipo de usuario es inválido, retorna null
            return null;
        }
    }



    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
