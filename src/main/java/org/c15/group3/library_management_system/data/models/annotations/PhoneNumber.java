package org.c15.group3.library_management_system.data.models.annotations;

import jakarta.validation.Constraint;
import org.c15.group3.library_management_system.services.validators.PhoneNumberValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Retention(RUNTIME)
@Target(value = {FIELD, PARAMETER, ANNOTATION_TYPE, METHOD})
public @interface PhoneNumber {


}
