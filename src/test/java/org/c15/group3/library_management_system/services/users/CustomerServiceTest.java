package org.c15.group3.library_management_system.services.users;

import org.c15.group3.library_management_system.data.dto.request.CreateCustomerRequest;
import org.c15.group3.library_management_system.data.dto.response.CreateCustomerResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {
	
	@Autowired
	private CustomerService customerService;
	private CreateCustomerRequest customerRequest;
	private CreateCustomerResponse customerResponse;
	
	@Test void registerCustomer(){
		customerResponse = customerService.registerCustomer(customerRequest);
	}
	
	@Test void saveCustomerTest(){
	
	}
}