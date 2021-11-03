package com.nt.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.nt.student.model.Register;

@Repository
public interface RegistrationRepo  extends JpaRepository<Register, Integer> {

	public Optional<Register> findByUsername(String userName);
}

