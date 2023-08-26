package org.c15.group3.library_management_system.services.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintValidatorContext.*;
import lombok.SneakyThrows;
import org.c15.group3.library_management_system.data.models.annotations.ValidDomain;
import org.c15.group3.library_management_system.exceptions.RequestInvalidException;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.c15.group3.library_management_system.utils.Constants.CONSTRAINT_VIOLATION_TEMPLATE_MESSAGE;

@ComponentScan
public class DomainValidator implements ConstraintValidator<ValidDomain, String> {

	private String[] domains;
	
	@Override
	public void initialize(ValidDomain constraintAnnotation) {
		domains = constraintAnnotation.domains();
	}
	
	@Override
	@SneakyThrows
	public boolean isValid(String email, ConstraintValidatorContext context) {
		String[] emailSplit = email.split("@");
		Stream<String> filteredDomainStream = Arrays.stream(domains).filter(domain -> domain.equals(emailSplit[1]));
		if (filteredDomainStream.findAny().isEmpty()) {
			String format = String.format(CONSTRAINT_VIOLATION_TEMPLATE_MESSAGE, Arrays.toString(domains));
			context.disableDefaultConstraintViolation();
			ConstraintViolationBuilder violationTemplate = context.buildConstraintViolationWithTemplate(format);
			violationTemplate.addConstraintViolation();
			throw new RequestInvalidException(violationTemplate.toString());
		}
		return true;
	}
}
