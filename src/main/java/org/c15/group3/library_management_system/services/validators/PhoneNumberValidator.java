package org.c15.group3.library_management_system.services.validators;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.c15.group3.library_management_system.data.dto.request.Phone;
import org.c15.group3.library_management_system.data.models.annotations.PhoneNumber;
import org.c15.group3.library_management_system.exceptions.RequestInvalidException;
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
		try {
			if (phone.getRegionCode() != null)
				return isValidForRegion(phone);
			return isValid(phone);
		} catch (RequestInvalidException | NumberParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean isValidForRegion(Phone phone) throws NumberParseException {
		Phonenumber.PhoneNumber parsedNumber = phoneNumberUtil.parse(phone.getPhoneNumber(), phone.getRegionCode());
		return phoneNumberUtil.isValidNumberForRegion(parsedNumber, phone.getRegionCode());
	}
	
	public boolean isValid(Phone phone) throws RequestInvalidException {
		if (phone.getPhoneNumber().charAt(0) == '+'){
			try {
				Phonenumber.PhoneNumber parsedNumber = phoneNumberUtil.parse(phone.getPhoneNumber(), null);
				return phoneNumberUtil.isValidNumber(parsedNumber);
			} catch (Exception e) {
				throw new RequestInvalidException(e.getMessage());
			}
		}
		return false;
	}
}
