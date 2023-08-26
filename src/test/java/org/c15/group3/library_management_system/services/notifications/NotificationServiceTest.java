package org.c15.group3.library_management_system.services.notifications;

import org.c15.group3.library_management_system.data.dto.request.Phone;
import org.c15.group3.library_management_system.services.notifications.textmessage.PhoneNumberValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class NotificationServiceTest {
	
	@Autowired
	PhoneNumberValidator phoneNumberValidator;
	
	@Test
	void validatePhoneNumberTest() {
		boolean isValid = phoneNumberValidator.isValid(new Phone("+2347036174617", "NG"));
		assertThat(isValid).isTrue();
	}
	
	@Test
	void validateEmailDomainTest() {
	
	}
	
	@Test
	void testThatValidDomainAnnotationWorks() {
	
	}
	
	@Test
	void testThatPhoneNumberAnnotationWorks() {
	
	}
	
	@Test
	void testThatIfPhoneNumberIsInternalFormat_CountryCodeIsNotRequired() {
	
	}
	
	@Test
	void testThatIfPhoneNumberIsNationalFormat_CountryCodeIsNotRequired(){
	
	}
	
	@Test void sendEmailTest(){
	
	}
}
