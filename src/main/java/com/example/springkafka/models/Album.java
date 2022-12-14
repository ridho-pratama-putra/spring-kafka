package com.example.springkafka.models;

import com.example.springkafka.enums.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Album {
    String id;
    String title;
    CategoryEnum categoryEnum;
    Date date;
}
