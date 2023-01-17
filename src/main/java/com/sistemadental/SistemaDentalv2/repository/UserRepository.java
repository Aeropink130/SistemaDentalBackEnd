package com.sistemadental.SistemaDentalv2.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadental.SistemaDentalv2.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
