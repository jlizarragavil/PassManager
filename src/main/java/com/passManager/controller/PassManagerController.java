package com.passManager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passManager.model.PassManager;
import com.passManager.repository.PassManagerRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PassManagerController {
	@Autowired
	PassManagerRepository PassManagerRepository;
	@GetMapping({ "/check" })
	public String check() {			
			return "OK";		
	}
	
	@GetMapping({ "/data", "/data/{user}" })
	public ResponseEntity<List<PassManager>> getAllProducts(@PathVariable(required = false) String user) {
		
			List<PassManager> passwords = new ArrayList<PassManager>();

			if (user == null) {
				PassManagerRepository.findAll().forEach(passwords::add);
				System.out.println("HOLA1");
			} else {
				PassManagerRepository.findByUser(user).forEach(passwords::add);
				System.out.println("HOLA2");
			}
			if (passwords.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(passwords, HttpStatus.OK);
		
	}
}
