package org.c15.group3.library_management_system.controller;

import lombok.AllArgsConstructor;
import org.c15.group3.library_management_system.data.dto.request.CreateCustomerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v3/library_management")
@AllArgsConstructor
public class LibraryCustomerController {
	
	
	public ResponseEntity<?> register(CreateCustomerRequest customerRequest){
		return null;
	}
	
	@GetMapping("/hello")
	public String getMapping(){
		return "Hello";
	}
}
