package org.c15.group3.library_management_system.services.users;

import com.google.i18n.phonenumbers.NumberParseException;
import lombok.AllArgsConstructor;
import org.c15.group3.library_management_system.data.dto.request.CreateCustomerRequest;
import org.c15.group3.library_management_system.data.dto.request.NotificationRequest;
import org.c15.group3.library_management_system.data.dto.request.Phone;
import org.c15.group3.library_management_system.data.dto.response.CreateCustomerResponse;
import org.c15.group3.library_management_system.exceptions.RequestInvalidException;
import org.c15.group3.library_management_system.services.validators.PasswordValidator;
import org.c15.group3.library_management_system.services.validators.PhoneNumberValidator;
import org.c15.group3.library_management_system.utils.JWTUtil;
import org.c15.group3.library_management_system.utils.TemplateLoader;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LibraryCustomerService implements CustomerService{
	private final PhoneNumberValidator phoneNumberValidator;
	private final PasswordValidator passwordValidator;
	private final ModelMapper modelMapper;
	
	@Override
	public CreateCustomerResponse registerCustomer(CreateCustomerRequest customerRequest) {
//		activateAccount(customerRequest);
		return null;
	}
	
	private void sendAccountActivationLink(CreateCustomerRequest customerRequest) throws NumberParseException, RequestInvalidException {
		boolean isValidPhoneNumber = validatePhoneNumber(customerRequest.getPhoneNumber());
		boolean isValidPassword = passwordValidator.isValid(customerRequest.getPassword());
		String phoneNumber = customerRequest.getPhoneNumber().getPhoneNumber();
		StringBuilder generatedUrl = JWTUtil.generateAccountActivationUrl(customerRequest.getEmail(), customerRequest.getPassword(), phoneNumber);
	}
	
	private boolean validatePhoneNumber(Phone phoneNumber) throws NumberParseException, RequestInvalidException {
		if (phoneNumber.getRegionCode() != null )
			return phoneNumberValidator.isValidForRegion(phoneNumber);
		else return phoneNumberValidator.isValid(phoneNumber);
	}
	
	
}
