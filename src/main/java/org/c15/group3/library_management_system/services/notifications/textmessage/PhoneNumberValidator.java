package org.c15.group3.library_management_system.services.notifications.textmessage;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.c15.group3.library_management_system.data.dto.request.Phone;
import org.c15.group3.library_management_system.data.models.annotations.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, Object> {
	private final PhoneNumberUtil phoneNumberUtil;
	@Override
	public void initialize(PhoneNumber constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Phone phone = (Phone) value;
			if (phone.getPhoneNumber().charAt(0) == '+'){
					try {
						Phonenumber.PhoneNumber parsedNumber = phoneNumberUtil.parse(phone.getPhoneNumber(), null);
						System.out.println("hi");
						System.out.println("Country code is:: " + parsedNumber.getCountryCode());
						System.out.println("extension is:: " + parsedNumber.getExtension());
						System.out.println("National number is:: " + parsedNumber.getNationalNumber());
						System.out.println(parsedNumber.clear());
						System.out.println("Clear country code:: " + parsedNumber.clearCountryCode());
						System.out.println("Clear country code source:: " + parsedNumber.clearCountryCodeSource());
						return phoneNumberUtil.isValidNumber(parsedNumber);
					} catch (Exception e) {
						return false; // Invalid format or region code
					}
			}
		return false;
	}
	
}
