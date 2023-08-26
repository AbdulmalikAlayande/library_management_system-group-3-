package org.c15.group3.library_management_system.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
	
	private String email;
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private String username;
}
