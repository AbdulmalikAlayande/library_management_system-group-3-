package org.c15.group3.library_management_system.data.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ApiResponse<R> {
	
	private R data;
	private boolean successful;
	private int statusCode;
}
