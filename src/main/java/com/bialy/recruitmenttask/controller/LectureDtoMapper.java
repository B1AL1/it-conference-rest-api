package com.bialy.recruitmenttask.controller;

import com.bialy.recruitmenttask.model.Lecture;
import com.bialy.recruitmenttask.model.LectureDto;
import com.bialy.recruitmenttask.model.User;
import com.bialy.recruitmenttask.model.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class LectureDtoMapper {

    private LectureDtoMapper(){}

    public static List<LectureDto> mapToLectureDtos(List<Lecture> lectures) {
        return lectures.stream()
                .map(lecture -> mapToUserDto(lecture))
                .collect(Collectors.toList());
    }

    public static LectureDto mapToUserDto(Lecture lecture) {
        return LectureDto.builder()
                .id(lecture.getId())
                .title(lecture.getTitle())
                .starting(lecture.getStarting())
                .ending(lecture.getEnding())
                .build();
    }

}
