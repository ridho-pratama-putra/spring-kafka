package com.example.springkafka.controllers;

import com.example.springkafka.models.Release;
import com.example.springkafka.services.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReleaseController {

    final RecommendationService service;

    public ReleaseController(RecommendationService service) {
        this.service = service;
    }

    @PostMapping("/album")
    public ResponseEntity createAlbum(@RequestBody Release release) {
        return service.produceTopicNewRelease(release);
    }
}
