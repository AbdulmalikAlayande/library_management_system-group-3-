package org.c15.group3.library_management_system.data.models.notifications;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Sender {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;
}
