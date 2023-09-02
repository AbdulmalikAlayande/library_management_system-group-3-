package org.c15.group3.library_management_system.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.c15.group3.library_management_system.exceptions.RegistrationFailedException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("test/api/v3/library_management/")
@AllArgsConstructor
public class LibraryCustomerController {
	
	@PostMapping("register/")
	public ResponseEntity<?> submitForm(@Valid @ModelAttribute TestPojoClass pojoClass, Model model, BindingResult bindingResult) throws RegistrationFailedException {
		if (bindingResult.hasErrors())
			throw new RegistrationFailedException("Registration Failed:: "+bindingResult.getFieldError()+"\n"+bindingResult.getAllErrors());
		return new ResponseEntity<String>(HttpStatusCode.valueOf(200));
	}
}
