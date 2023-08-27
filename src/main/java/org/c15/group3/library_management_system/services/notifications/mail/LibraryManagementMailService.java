package org.c15.group3.library_management_system.services.notifications.mail;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.c15.group3.library_management_system.config.AppConfig;
import org.c15.group3.library_management_system.data.dto.request.NotificationRequest;
import org.c15.group3.library_management_system.data.dto.response.NotificationResponse;
import org.c15.group3.library_management_system.data.models.Abstract.Notification;
import org.c15.group3.library_management_system.data.models.notifications.Email;
import org.c15.group3.library_management_system.data.models.notifications.Recipient;
import org.c15.group3.library_management_system.data.models.notifications.Sender;
import org.c15.group3.library_management_system.exceptions.RequestInvalidException;
import org.c15.group3.library_management_system.utils.TemplateLoader;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.TemplateEngine;

import java.util.Collections;
import java.util.Objects;

import static org.c15.group3.library_management_system.utils.Constants.*;
import static org.c15.group3.library_management_system.utils.JWTUtil.generateAccountActivationUrl;

@Service
@AllArgsConstructor
@Slf4j
public class LibraryManagementMailService implements MailService{
	
	
	private final ResourceLoader resourceLoader;
	private final RestTemplate restTemplate;
	private final TemplateEngine templateEngine;
	private ModelMapper modelMapper;
	private AppConfig appConfig;
	
	@Override
	public ResponseEntity<NotificationResponse> sendAccountActivationMail(NotificationRequest notificationRequest) throws RequestInvalidException {
		HttpHeaders headers = new HttpHeaders();
		headers.set(API_KEY, appConfig.getMailApiKey());
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Resource foundTemplateResource = resourceLoader.getResource(ACTIVATION_MAIL_PATH);
		String templateContent = TemplateLoader.loadTemplateContent(foundTemplateResource);
		
		Recipient recipient = new Recipient();
		modelMapper.map(notificationRequest, recipient);
		
		Notification notification = new Email();
		notification.setRecipients(Collections.singletonList(recipient));
		notification.setSender(Sender.builder().name(SENDER_FULL_NAME).email(SENDER_EMAIL).build());
		notification.setSubject(MESSAGE_SUBJECT);
		notification.setHtmlContent(templateContent);
		
		HttpEntity<Notification> requestEntity = new HttpEntity<>(notification, headers);
		ResponseEntity<NotificationResponse> response = restTemplate.postForEntity(
				BREVO_SEND_EMAIL_API_URL,
				requestEntity, NotificationResponse.class
		);
		if (response.getStatusCode().is2xxSuccessful())
			log.info("{} response body:: {}", MESSAGE_SUCCESSFULLY_SENT, Objects.requireNonNull(response.getBody()));
		else log.error("{} response body:: {}", MESSAGE_FAILED_TO_SEND, Objects.requireNonNull(response.getBody()));
		return response;
	}
	
	@Override
	public String getTemplate(Model model, NotificationRequest notificationRequest) {
		model.addAttribute("Username", notificationRequest.getFirstName()+notificationRequest.getLastName());
		model.addAttribute("activationLink",
				generateAccountActivationUrl(notificationRequest.getEmail(), notificationRequest.getPassword(), notificationRequest.getPhoneNumber()));
		return "account_activation_mail_template";
	}
}
