package org.c15.group3.library_management_system.data.models.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DomainValidator implements ConstraintValidator<ValidDomain, String> {

	private String[] domains;
	@Override
	public void initialize(ValidDomain constraintAnnotation) {
		domains = constraintAnnotation.domains();
	}
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		String[] emailSplit = email.split("@");
		
		return false;
	}
}
