package com.bialy.recruitmenttask.controller;

import com.bialy.recruitmenttask.model.Lecture;
import com.bialy.recruitmenttask.model.LectureDto;

import java.util.List;
import java.util.stream.Collectors;

public class LectureDtoMapper {

    private LectureDtoMapper(){}

    public static List<LectureDto> mapToLecturesDto(List<Lecture> lectures) {
        return lectures.stream()
                .map(lecture -> mapToLectureDto(lecture))
                .collect(Collectors.toList());
    }

    public static LectureDto mapToLectureDto(Lecture lecture) {
        return LectureDto.builder()
                .id(lecture.getId())
                .title(lecture.getTitle())
                .starting(lecture.getStarting())
                .ending(lecture.getEnding())
                .thematic_path(lecture.getThematic_path())
                .build();
    }

}
