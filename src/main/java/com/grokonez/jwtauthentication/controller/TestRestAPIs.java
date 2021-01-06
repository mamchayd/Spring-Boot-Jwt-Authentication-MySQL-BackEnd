package com.grokonez.jwtauthentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {

	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/etudiant")
	@PreAuthorize("hasRole('ETUDIANT') or hasRole('ADMIN')")
	public String etudiantAccess() {
		return ">>> etudiant Contents!";
	}

	@GetMapping("/api/test/consultant")
	@PreAuthorize("hasRole('CONSULTANT') or hasRole('ADMIN')")
	public String consultantAccess() {
		return ">>> consultant Contents!";
	}

	@GetMapping("/api/test/professeur")
	@PreAuthorize("hasRole('PROFESSEUR') or hasRole('ADMIN')")
	public String professeurAccess() {
		return ">>> professeur Contents!";
	}

	@GetMapping("/api/test/parent")
	@PreAuthorize("hasRole('PARENT') or hasRole('ADMIN')")
	public String parentAccess() {
		return ">>> Parent Contents";
	}

	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}
}
