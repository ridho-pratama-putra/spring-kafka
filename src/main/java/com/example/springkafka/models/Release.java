package com.example.springkafka.models;

import com.example.springkafka.enums.CategoryEnum;
import com.example.springkafka.enums.ReleaseType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
@Data
public class Release {
    @Id
    String id;
    String title;
    List<CategoryEnum> category;

    ReleaseType releaseType;

    @CreatedBy
    private String createdByUser;

    @CreatedDate
    private LocalDateTime creationDate = LocalDateTime.now();

    @LastModifiedDate
    private Date lastModifiedDate;

    @LastModifiedBy
    private String lastModifiedUserId;

    LocalDateTime releaseDate;
    List<Song> songList;
    String duration;
    @DocumentReference(lazy = true)
    Artist artist;
}
