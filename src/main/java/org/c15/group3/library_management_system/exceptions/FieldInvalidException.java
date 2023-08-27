package org.c15.group3.library_management_system.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldInvalidException extends Exception{
	
	private String cause;
	private String[] reasons;
	
	public FieldInvalidException(String message) {
		super(message);
	}
	public FieldInvalidException(Throwable throwable) {
		super(throwable);
	}
	public FieldInvalidException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
