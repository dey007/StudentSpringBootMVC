package com.nt.student.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.nt.student.model.Register;

public interface RegistrationService extends UserDetailsService {

	public String registration(Register register);
}
