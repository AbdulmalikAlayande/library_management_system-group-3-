package org.c15.group3.library_management_system.data.models.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.c15.group3.library_management_system.services.validators.DomainValidator;
import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target(value = {ANNOTATION_TYPE, FIELD, PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DomainValidator.class)
@Documented
@ComponentScan
public @interface ValidDomain {
	
	String[] domains() default {"gmail.com", "outlook.com", "yahoo.com", "hotmail.com"};
	String message() default "Invalid domain";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
