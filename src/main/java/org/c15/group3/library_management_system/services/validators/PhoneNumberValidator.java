package org.c15.group3.library_management_system.services.validators;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.c15.group3.library_management_system.data.models.annotations.PhoneNumber;
import org.springframework.stereotype.Service;

//@Service
//@AllArgsConstructor
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
	private PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
	
	@Override
	public void initialize(PhoneNumber constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	
	@Override
	public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
		try {
			Phonenumber.PhoneNumber parsedNumber = phoneNumberUtil.parse(phoneNumber, null);
			System.out.println("hi");
			System.out.println("Country code is:: "+parsedNumber.getCountryCode());
			System.out.println("extension is:: "+parsedNumber.getExtension());
			System.out.println("National number is:: "+parsedNumber.getNationalNumber());
			System.out.println(parsedNumber.clear());
			System.out.println("Clear country code:: "+parsedNumber.clearCountryCode());
			System.out.println("Clear country code source:: "+parsedNumber.clearCountryCodeSource());
			return phoneNumberUtil.isValidNumber(parsedNumber);
		} catch (Exception e) {
			return false; // Invalid format or region code
		}
	}
	
}
