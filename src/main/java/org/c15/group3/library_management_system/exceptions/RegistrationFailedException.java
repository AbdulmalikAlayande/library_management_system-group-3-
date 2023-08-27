package org.c15.group3.library_management_system.exceptions;

public class RegistrationFailedException extends Exception{
	
	public RegistrationFailedException(String message) {
		super(message);
	}
	public RegistrationFailedException(Throwable throwable) {
		super(throwable);
	}
	public RegistrationFailedException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
