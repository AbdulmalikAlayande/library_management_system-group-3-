package org.c15.group3.library_management_system.data.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.c15.group3.library_management_system.data.models.annotations.Password;
import org.c15.group3.library_management_system.data.models.annotations.PhoneNumber;
import org.c15.group3.library_management_system.data.models.annotations.ValidDomain;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCustomerRequest {
	@NotBlank
	private String firstname;
	private String lastname;
	@Valid
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
	@ValidDomain(domains = {"gmail.com", "yahoo.com", "outlook.com", "semicolon.africa.com", "hotmail.com", "hotmail.co.uk", "freenet.de"})
	@NotBlank
	private String email;
	
	private String regionCode;
	@PhoneNumber
	private Phone phoneNumber;
	@Password
	private String password;

}
