package org.c15.group3.library_management_system.services.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.c15.group3.library_management_system.data.models.annotations.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
	@Override
	public void initialize(PhoneNumber constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	
	@Override
	public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
		return false;
	}
}
