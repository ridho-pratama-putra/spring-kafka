package com.example.springkafka.services;

import com.example.springkafka.models.Release;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    final KafkaTemplate<String, String> template;

    public ResponseEntity<Object> produceTopicNewRelease(Release release) {
        ObjectMapper objectMapper = new ObjectMapper();
        String message;
        try {
            message = objectMapper.writeValueAsString(release);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(release, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        template.send("MUSIC_RECOMMENDATION", release.getArtist().getName(), message);
        return new ResponseEntity<>(release, HttpStatus.CREATED);
    }
}
