package com.nt.student.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.student.model.Register;
import com.nt.student.service.RegistrationService;

@Controller
@RequestMapping("/student")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/register")
	public String registrationForm(@ModelAttribute("reg") Register register) {
		return "register";
	}
	
	@PostMapping("/register")
	public String registration(@ModelAttribute("reg") Register register, Map<String,Object> map) {
		String message = registrationService.registration(register);
		map.put("resultMsg", message);
		return "login";
	}
	
}
