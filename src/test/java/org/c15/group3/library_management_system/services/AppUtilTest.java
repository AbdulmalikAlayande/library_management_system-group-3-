package org.c15.group3.library_management_system.services;

import org.c15.group3.library_management_system.utils.JWTUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AppUtilTest {
	
	@Test void testThatTokenIsGeneratedForEmail(){
		String token = JWTUtil.generateAccountActivationToken("alaabdulmalik03@gmail.com", "ayanniyi@20", null);
		System.out.println("token:: "+token);
		assertThat(token).isNotNull();
	}
	
	@Test void testThatTokenIsGeneratedForPhoneNumbers(){
		String token = JWTUtil.generateAccountActivationToken(null, "ayanniyi@20", "+2347036174617");
		System.out.println("token:: "+token);
		assertThat(token).isNotNull();
	}
	
	@Test void testThatAccountActivationTokenIsContainsBaseUrl(){
		String token = JWTUtil.generateAccountActivationUrl(null, "ayanniyi@20", "+2347036174617");
		System.out.println("token:: "+token);
		assertThat(token).contains("https://localhost:3000/library_management");
	}
	
	@Test void generatedTokenCanBeDecodedAsAValidJWTToken(){
		String password = "ayanniyi@20";
		String phoneNumber = "+2347036174617";
		String token = JWTUtil.generateAccountActivationToken(null, password, phoneNumber);
		assertThat(JWTUtil.isValidToken(token, "text message", password)).isTrue();
	}
	
	@Test void testThatEmailCanBeExtractedFromToken(){
		String password = "ayanniyi@20";
		String phoneNumber = "+2347036174617";
		String token = JWTUtil.generateAccountActivationToken(null, password, phoneNumber);
		String email = JWTUtil.extractEmailFrom(token);
	}
	
	@Test void testThatPasswordCanBeExtractedFromToken(){
		String password = "ayanniyi@20";
		String phoneNumber = "+2347036174617";
		String token = JWTUtil.generateAccountActivationToken(null, password, phoneNumber);
		String extractedPhoneNumber = JWTUtil.extractPhoneNumberFrom(token);
		assertThat(extractedPhoneNumber).isEqualTo(phoneNumber);
	}
	
	@Test void testThatFullPayloadCanBeExtractedFromToken(){
	
	}
}
