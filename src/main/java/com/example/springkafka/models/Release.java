package com.example.springkafka.models;

import com.example.springkafka.enums.CategoryEnum;
import com.example.springkafka.enums.ReleaseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
@Data
public class Release {
    @Id
    String id;
    ReleaseType releaseType;
    String title;
    CategoryEnum categoryEnum;

    @CreatedBy
    private String createdByUser;

    @CreatedDate
    private LocalDateTime creationDate = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @LastModifiedBy
    private String lastModifiedUserId;

    LocalDateTime releaseDate;
    List<Song> songList;
    String duration;
    @DocumentReference(lazy = true)
    Artist artist;
}
