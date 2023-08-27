package org.c15.group3.library_management_system.services.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.c15.group3.library_management_system.data.models.annotations.Password;

public class PasswordValidator implements ConstraintValidator<Password, String> {
	@Override
	public void initialize(Password constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return false;
	}
}
