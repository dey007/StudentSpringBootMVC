package com.nt.student.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.student.model.Register;
import com.nt.student.repo.RegistrationRepo;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private RegistrationRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Register> registerDetails = repo.findByUsername(username);
		if (registerDetails.isEmpty())
			throw new IllegalArgumentException("User Not Found");
		else {
			Register reg = registerDetails.get();
			User user = new User(reg.getUsername(), reg.getPassword(),
					reg.getRole().stream().map(r -> new SimpleGrantedAuthority(r)).collect(Collectors.toSet()));
			return user;
		}
	}

	@Override
	public String registration(Register register) {
		register.setPassword(encoder.encode(register.getPassword()));
		return repo.save(register).getUsername() + " registered Successfylly";
	}

}
