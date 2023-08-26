package org.c15.group3.library_management_system.config;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
@Configuration
@Getter
public class AppConfig {
	
	@Value("${mail.api.key}")
	private String mailApiKey;
	@Value("${cloud.api.key}")
	private String cloudApiKey;
	@Value("${tmsg.api.key}")
	private String textMessageApiKey;
	@Value("${cloud.api.name}")
	private String cloudApiName;
	@Value("${cloud.api.secret}")
	private String cloudApiSecret;
	@Value("${jwt.util.secret}")
	private String jwtSecret;
	
	@Bean
	public PhoneNumberUtil getPhoneNumberUtil(){
		return PhoneNumberUtil.getInstance();
	}
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
	
	@Bean
	public AppConfig getAppConfig(){
		return new AppConfig();
	}
	
}
