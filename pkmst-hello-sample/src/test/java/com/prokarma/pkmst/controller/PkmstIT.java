package com.prokarma.pkmst.controller;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.prokarma.pkmst.PkmstApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PkmstApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PkmstIT {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testGreetMessage() {
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/hello/TestUser"),
				HttpMethod.GET, entity, String.class);		
		Assert.assertEquals("Hello Welcome : TestUser", response.getBody());

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}