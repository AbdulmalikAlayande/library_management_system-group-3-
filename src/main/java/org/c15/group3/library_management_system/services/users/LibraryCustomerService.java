package org.c15.group3.library_management_system.services.users;

import lombok.AllArgsConstructor;
import org.c15.group3.library_management_system.data.dto.request.CreateCustomerRequest;
import org.c15.group3.library_management_system.data.dto.response.CreateCustomerResponse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LibraryCustomerService implements CustomerService{
	
	
	
	@Override
	public CreateCustomerResponse registerCustomer(CreateCustomerRequest customerRequest) {
		return null;
	}
	
	
}
