package com.example.springkafka.enums;

public enum ReleaseType {
    ALBUM("Album")
    , SINGLE("Single");

    final String displayText;

    ReleaseType(String displayText) {
        this.displayText = displayText;
    }
}
