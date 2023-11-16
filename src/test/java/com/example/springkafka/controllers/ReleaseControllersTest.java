package com.example.springkafka.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.example.springkafka.models.Release;
import com.example.springkafka.services.RecommendationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class ReleaseControllersTest {
    
    @MockBean
    RecommendationService recommendationService;

	@Autowired
	private MockMvc mockMvc;

    @Test
    void createAlbum_shouldCallService_whenCalled() throws Exception {
        Release build = Release.builder().build();
        ResponseEntity<Release> serviceResponse = new ResponseEntity<>(build, HttpStatus.CREATED);
        Mockito.when(recommendationService.produceTopicNewRelease(Mockito.any(Release.class))).thenReturn(serviceResponse);
        
        mockMvc
            .perform(MockMvcRequestBuilders.post("/album")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(build)))
            .andExpect(MockMvcResultMatchers.status().isCreated())
        ;
        
        Mockito.verify(recommendationService, Mockito.times(1)).produceTopicNewRelease(Mockito.any());
    }
}
