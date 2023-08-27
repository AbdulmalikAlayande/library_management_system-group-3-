package org.c15.group3.library_management_system.services.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;
import org.c15.group3.library_management_system.data.models.annotations.Password;
import org.c15.group3.library_management_system.exceptions.FieldInvalidException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {
	
	private String regExpression;
	@Override
	public void initialize(Password constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
		regExpression = constraintAnnotation.regexp();
	}
	
	@SneakyThrows
	@Override
	public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
		Pattern compiledPattern = Pattern.compile(regExpression);
		if (!compiledPattern.matcher(phoneNumber).matches()) {
			FieldInvalidException fieldInvalidException = new FieldInvalidException("Invalid Password");
			fieldInvalidException.setCause("Password does not obey stated contract for password");
			fieldInvalidException.setReasons(new String[]{
					"Password must be between 8-12 characters long",
					"Password must contain at least one uppercase letter and one digit",
					"Password must contain at least one of the special characters: @, #, $, &, ., !, *,"
			});
			throw fieldInvalidException;
		}
		return true;
	}
}
