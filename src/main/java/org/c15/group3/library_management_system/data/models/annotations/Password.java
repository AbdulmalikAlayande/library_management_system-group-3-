package org.c15.group3.library_management_system.data.models.annotations;

public @interface Password {
	
	String regexp() default "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$&.!*?]).{8,12}$";
}
