package com.bialy.recruitmenttask.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class LectureDto {
    private long id;
    private String title;
    private LocalDateTime starting;
    private LocalDateTime ending;
    private final int max_amount_of_users = 5;
    private int thematic_path;
}
