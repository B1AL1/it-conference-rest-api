package com.bialy.recruitmenttask.controller;

import com.bialy.recruitmenttask.model.Lecture;
import com.bialy.recruitmenttask.model.LectureDto;
import com.bialy.recruitmenttask.service.LectureSevice;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.bialy.recruitmenttask.controller.LectureDtoMapper.mapToLectureDtos;

@RestController
@RequestMapping("/api/v1/lecture")
@AllArgsConstructor
public class LectureController {

    private final LectureSevice lectureSevice;

    @GetMapping
    public List<LectureDto> getLectures() { return mapToLectureDtos(lectureSevice.getLectures()); }
}
