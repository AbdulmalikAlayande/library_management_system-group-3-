package org.c15.group3.library_management_system.services.books;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.c15.group3.library_management_system.services.validators.PhoneNumberValidator;

public class BookService {
	private PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
	
	
	public boolean hello(String phoneNumber) throws NumberParseException {
		Phonenumber.PhoneNumber parsedNumber = phoneNumberUtil.parse(phoneNumber, "NG");
		System.out.println("hi");
		System.out.println("Country code is:: "+parsedNumber.getCountryCode());
		System.out.println("extension is:: "+parsedNumber.getExtension());
		System.out.println("National number is:: "+parsedNumber.getNationalNumber());
		System.out.println(parsedNumber.clear());
		System.out.println("Clear country code:: "+parsedNumber.clearCountryCode());
		System.out.println("Clear country code source:: "+parsedNumber.clearCountryCodeSource());
		return phoneNumberUtil.isValidNumber(parsedNumber);
	}
	
	public static void main(String[] args) throws NumberParseException {
		BookService bookService = new BookService();
		bookService.hello("+2347036174617");
	}
}
