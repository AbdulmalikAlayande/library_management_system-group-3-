package org.c15.group3.library_management_system.utils;

import lombok.extern.slf4j.Slf4j;
import org.c15.group3.library_management_system.data.dto.request.NotificationRequest;
import org.c15.group3.library_management_system.exceptions.RequestInvalidException;
import org.springframework.core.io.Resource;
import org.springframework.ui.Model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Formatter;

import static org.c15.group3.library_management_system.utils.Constants.TEMPLATE_LOAD_FAILED;
import static org.c15.group3.library_management_system.utils.JWTUtil.generateAccountActivationUrl;

@Slf4j
public class TemplateLoader {
	
	public static String loadTemplateContent(Resource templateResource) throws RequestInvalidException {
		Formatter formatter = new Formatter();
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		try {
			InputStream inputStream = templateResource.getInputStream();
			byte[] buffer = new byte[1024];
			int length;
			while ((length = inputStream.read(buffer)) != -1) {
				result.write(buffer, 0, length);
			}
		} catch (IOException exception) {
			log.error(TEMPLATE_LOAD_FAILED, exception);
			throw new RequestInvalidException(TEMPLATE_LOAD_FAILED, exception);
		}
		return result.toString(StandardCharsets.UTF_8);
	}
	
	public static String getTemplate(Model model, NotificationRequest notificationRequest) {
		model.addAttribute("Username", notificationRequest.getFirstName()+notificationRequest.getLastName());
		model.addAttribute("activationLink",
				generateAccountActivationUrl(notificationRequest.getEmail(), notificationRequest.getPassword(), notificationRequest.getPhoneNumber()));
		return "account_activation_mail_template";
	}
}
