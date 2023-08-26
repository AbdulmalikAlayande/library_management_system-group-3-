package org.c15.group3.library_management_system.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;
import java.util.Objects;

public class JWTUtil {

	public static String generateAccountActivationToken(String email, String password, String phoneNumber){
		JWTCreator.Builder tokenCreator;
		if (email != null)
		    tokenCreator = buildTokenForEmails(email, password);
		else tokenCreator = buildTokenForTextMessages(phoneNumber, password);
		return tokenCreator.sign(Algorithm.HMAC512(email+password));
	}
	
	private static JWTCreator.Builder buildTokenForTextMessages(String phoneNumber, String password) {
		return JWT.create()
				  .withClaim("user phone number", phoneNumber)
				  .withClaim("user password", password)
//				  .withHeader("text message token")
				  .withIssuer("Library Management Incorporation")
				  .withExpiresAt(Instant.now().plusSeconds(7200))
				  .withIssuedAt(Instant.now());
	}
	
	private static JWTCreator.Builder buildTokenForEmails(String email, String password) {
		return JWT.create()
				  .withClaim("user mail", email)
				  .withClaim("user password", password)
//				  .withHeader("mail message token")
				  .withExpiresAt(Instant.now().plusSeconds(3600))
				  .withIssuer("Library Management Incorporation")
				  .withIssuedAt(Instant.now());
	}
	
	public static String generateAccountActivationUrl(String email, String password, String phoneNumber){
		String baseUrl = "https://localhost/3000/library_management/activate-account";
		String queryStringPrefix = "?";
		String queryStringToken = "token=";
		String generatedToken =  generateAccountActivationToken(email, password, phoneNumber);
		return baseUrl+queryStringPrefix+queryStringToken+generatedToken;
	}
	
	public static boolean isValidToken(String token, String notificationMedium) {
		if (Objects.equals(notificationMedium, "mail")) {
			JWTVerifier verifier = JWT.require(Algorithm.HMAC512("secret"))
					                       .withIssuer("Library Management Incorporation")
					                       .withClaimPresence("user mail")
					                       .build();
			return verifier.verify(token)!=null;
		}
		if (Objects.equals(notificationMedium, "text message")) {
			JWTVerifier verifier = JWT.require(Algorithm.HMAC512("secret"))
					                       .withIssuer("Library Management Incorporation")
					                       .withClaimPresence("user phone number")
					                       .build();
			return verifier.verify(token)!=null;
		}
		else return false;
	}
}
