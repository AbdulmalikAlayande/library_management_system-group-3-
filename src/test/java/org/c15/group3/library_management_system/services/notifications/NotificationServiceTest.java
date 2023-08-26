package org.c15.group3.library_management_system.services.notifications;

import lombok.SneakyThrows;
import org.c15.group3.library_management_system.data.dto.request.NotificationRequest;
import org.c15.group3.library_management_system.data.dto.request.Phone;
import org.c15.group3.library_management_system.data.dto.response.NotificationResponse;
import org.c15.group3.library_management_system.data.models.annotations.ValidDomain;
import org.c15.group3.library_management_system.services.notifications.mail.DomainValidator;
import org.c15.group3.library_management_system.services.notifications.mail.MailService;
import org.c15.group3.library_management_system.services.notifications.textmessage.PhoneNumberValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class NotificationServiceTest {
	
	@Autowired
	PhoneNumberValidator phoneNumberValidator;
	@Autowired
	DomainValidator domainValidator;
	@Autowired
	private MailService mailService;
	@ValidDomain
	private String email;
	
	@Test
	@SneakyThrows
	void validatePhoneNumberTest() {
		boolean isValid = phoneNumberValidator.isValidForRegion(new Phone("+2347036174617", "NG"));
		assertThat(isValid).isTrue();
		boolean isValidForRegion = phoneNumberValidator.isValidForRegion(new Phone("07036174717", "NG"));
		assertThat(isValid).isTrue();
		boolean isValidPhoneNumber = phoneNumberValidator.isValid(new Phone("+234 703 617 461 7", "ZZ"));
		assertThat(isValidPhoneNumber).isTrue();
		boolean isNot = phoneNumberValidator.isValid(new Phone("07036174617", "ZZ"));
		assertThat(isNot).isFalse();
		boolean isNotValid = phoneNumberValidator.isValid(new Phone("07036174617", null));
		assertThat(isNotValid).isFalse();
	}
	
	@Test
	void validateEmailDomainTest() {
		boolean isValid = domainValidator.isValid("alaabddulmalik@");
		assertThat(isValid).isFalse();
		boolean isValid1 = domainValidator.isValid("alaabdulmalik03@gmail.com");
		assertThat(isValid1).isTrue();
	}
	
	@Test
	void testThatValidDomainAnnotationWorks() {
		email = "alaabdulmalik@";
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
	
	@Test
	@SneakyThrows
	void sendEmailTest(){
		NotificationRequest notificationRequest = NotificationRequest.builder()
				                                          .lastName("Alayande")
				                                          .firstName("Abdulmalik")
				                                          .email("alaabdulmalik03@gmail")
				                                          .username("abolade")
				                                          .phoneNumber("07036174617")
				                                          .build();
		ResponseEntity<NotificationResponse> response = mailService.sendAccountActivationMail(notificationRequest);
		assertThat(response.getBody()).isNotNull();
	}
}
