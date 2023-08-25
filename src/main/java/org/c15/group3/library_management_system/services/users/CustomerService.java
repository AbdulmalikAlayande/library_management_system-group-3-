package org.c15.group3.library_management_system.services.users;

import org.c15.group3.library_management_system.data.dto.request.CreateCustomerRequest;
import org.c15.group3.library_management_system.data.dto.response.CreateCustomerResponse;

public interface CustomerService {
	
	CreateCustomerResponse registerCustomer(CreateCustomerRequest customerRequest);
	
}
