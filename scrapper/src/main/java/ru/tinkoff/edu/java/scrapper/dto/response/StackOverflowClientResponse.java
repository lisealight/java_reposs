package ru.tinkoff.edu.java.scrapper.dto.response;

import lombok.Data;

import java.time.OffsetDateTime;


@Data
public class StackOverflowClientResponse {
    long question_id;
    OffsetDateTime last_activity_date;
}


