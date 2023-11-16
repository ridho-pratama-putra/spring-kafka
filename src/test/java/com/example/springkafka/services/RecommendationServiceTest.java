package com.example.springkafka.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;

import com.example.springkafka.models.Artist;
import com.example.springkafka.models.Release;

@SpringBootTest
public class RecommendationServiceTest {
    
    @MockBean
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    RecommendationService recommendationService;

    @Test
    void produceTopicNewRelease_shouldSuccessCallKafka_whenCalled() {
        Release build = Release.builder()
            .artist(Artist.builder().name("endank").displayName("Endank").build())
        .build();
        
        recommendationService.produceTopicNewRelease(build);

        Mockito.verify(kafkaTemplate, Mockito.times(1)).send(Mockito.anyString(), Mockito.any(), Mockito.any());
    }
}
