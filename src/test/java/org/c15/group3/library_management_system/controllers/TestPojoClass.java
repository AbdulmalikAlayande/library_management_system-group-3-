package org.c15.group3.library_management_system.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.c15.group3.library_management_system.data.models.annotations.Password;
import org.c15.group3.library_management_system.data.models.annotations.PhoneNumber;
import org.c15.group3.library_management_system.data.models.annotations.ValidDomain;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestPojoClass {
	
	private String id;
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
	@ValidDomain(domains = {"gmail.com", "yahoo.com", "outlook.com", "semicolon.africa.com", "hotmail.com", "hotmail.co.uk", "freenet.de"})
	@NotBlank
	@Valid
	private String email;
	@Password
	@Valid
	private String password;
	@PhoneNumber
	@Valid
	private String phoneNumber;
}
