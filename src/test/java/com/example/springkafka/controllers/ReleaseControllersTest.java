package com.example.springkafka.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.springkafka.models.Release;
import com.example.springkafka.services.RecommendationService;

@EnableAutoConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ReleaseControllersTest {
    
    @MockBean
    RecommendationService recommendationService;

    @LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

    @Test
    void createAlbum_shouldCallService_whenCalled() {
        Release build = Release.builder().build();
        ResponseEntity<Release> serviceResponse = new ResponseEntity<>(Release.builder().build(), HttpStatus.CREATED);
        Mockito.when(recommendationService.produceTopicNewRelease(Mockito.any(Release.class))).thenReturn(serviceResponse);
        
        ResponseEntity<Release> postForEntity = restTemplate
            .postForEntity("/album", build, Release.class);
        
        Mockito.verify(recommendationService, Mockito.times(1)).produceTopicNewRelease(Mockito.any());
        assertEquals(serviceResponse.getStatusCode(), postForEntity.getStatusCode());
    }
}
