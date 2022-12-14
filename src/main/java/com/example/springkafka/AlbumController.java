package com.example.springkafka;

import com.example.springkafka.models.Album;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumController {

   Logger logger = LoggerFactory.getLogger(AlbumController.class);

    @PostMapping("/album")
    public ResponseEntity createAlbum(@RequestBody Album album) {
        logger.info("album ::: " + album.getTitle());
        return new ResponseEntity(album, HttpStatus.CREATED);
    }
}
