package org.c15.group3.library_management_system.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AnnotationTest {
	@LocalServerPort
	private int serverPort;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private TestRestTemplate testRestTemplate;
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Test void testThatEmailAndValidDomainAnnotationWorks() throws Exception {
		TestPojoClass testPojoClass = new TestPojoClass();
		testPojoClass.setEmail("alaalal3g");
		testPojoClass.setPassword("adin ross");
		testPojoClass.setPhoneNumber("0804567839");
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		BindingResult bindingResult = new BeanPropertyBindingResult(new TestPojoClass(), "testPojoClass");
		mockMvc.perform(MockMvcRequestBuilders.post("/submit")
				                .content(objectMapper.writeValueAsString(testPojoClass))
				                
				                .contentType(MediaType.APPLICATION_JSON)
		);
	}
}
