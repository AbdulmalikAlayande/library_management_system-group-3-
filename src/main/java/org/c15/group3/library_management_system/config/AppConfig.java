package org.c15.group3.library_management_system.config;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
public class AppConfig {
	
	@Bean
	public PhoneNumberUtil getPhoneNumberUtil(){
		return PhoneNumberUtil.getInstance();
	}
}
