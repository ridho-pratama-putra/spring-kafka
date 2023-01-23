package com.example.springkafka.services;

import com.example.springkafka.models.Release;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    public ResponseEntity produceTopicNewRelease(Release release) {
        return new ResponseEntity<Object>(release, HttpStatus.CREATED);
    }
}
