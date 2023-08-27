package org.c15.group3.library_management_system.services.notifications.mail;

import org.c15.group3.library_management_system.data.dto.request.NotificationRequest;
import org.c15.group3.library_management_system.data.dto.response.ApiResponse;
import org.c15.group3.library_management_system.data.dto.response.NotificationResponse;
import org.c15.group3.library_management_system.exceptions.RequestInvalidException;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

public interface MailService {
	
	ResponseEntity<NotificationResponse> sendAccountActivationMail(NotificationRequest notificationRequest) throws RequestInvalidException;
	String getTemplate(Model model, NotificationRequest notificationRequest);
}
