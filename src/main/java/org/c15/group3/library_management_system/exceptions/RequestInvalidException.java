package org.c15.group3.library_management_system.exceptions;

public class RequestInvalidException extends Exception{
	
	public RequestInvalidException(String message){
		super(message);
	}
	
	public RequestInvalidException(String message, Throwable throwable){
		super(message, throwable);
	}
}
