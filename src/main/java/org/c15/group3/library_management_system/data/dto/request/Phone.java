package org.c15.group3.library_management_system.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Phone {
	
	private String phoneNumber;
	private String regionCode;
}
