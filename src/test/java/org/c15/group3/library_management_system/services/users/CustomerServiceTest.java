package org.c15.group3.library_management_system.services.users;

import lombok.SneakyThrows;
import org.c15.group3.library_management_system.data.dto.request.CreateCustomerRequest;
import org.c15.group3.library_management_system.data.dto.response.CreateCustomerResponse;
import org.c15.group3.library_management_system.exceptions.RegistrationFailedException;
import org.c15.group3.library_management_system.exceptions.RequestInvalidException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {
	
	@Autowired
	private CustomerService customerService;
	private CreateCustomerRequest customerRequest;
	private CreateCustomerResponse customerResponse;
	
	@BeforeEach
	void startEachTestWith() {
		customerResponse = customerService.registerCustomer(customerRequest);
	}
	
	@Test
	void testThatCustomerEntersInInvalidDetails_RegistrationFailedExceptionIsThrown() {
		assertThatThrownBy(()-> customerService.registerCustomer(buildCustomerWithInvalidDetails()))
				.isExactlyInstanceOf(RequestInvalidException.class)
				.hasMessageContaining("Invalid domain");
	}
	
	private CreateCustomerRequest buildCustomerWithInvalidDetails() {
		return CreateCustomerRequest.builder()
				       .email("alaabdul")
				       .firstname("Abdulmalik")
				       .lastname("Alayande")
				       .password("Ayanniyi@20")
				       .build();
	}
	
	@SneakyThrows
	@Test
	void whenPassengerTriesToRegisterTwice_RegistrationFailedExceptionIsThrown() {
		
	}
	
	@SneakyThrows
	@Test
	void testThatPassengerTriesToRegisterWithIncomplete_Required_Details_ExceptionIsThrown() {
		
	}
	
	
	@SneakyThrows
	@Test void testThatPassengerCanRegisterSuccessfully_And_ActivationLinkIsSentToThem_IfAllChecksArePassed(){
	
	}
	
	@Test void saveCustomerTest(){
	
	}
}