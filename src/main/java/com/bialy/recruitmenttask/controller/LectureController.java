package com.bialy.recruitmenttask.controller;

import com.bialy.recruitmenttask.model.Lecture;
import com.bialy.recruitmenttask.model.LectureDto;
import com.bialy.recruitmenttask.model.User;
import com.bialy.recruitmenttask.service.LectureSevice;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bialy.recruitmenttask.controller.LectureDtoMapper.mapToLectureDtos;

@RestController
@RequestMapping("/api/v1/lecture")
@AllArgsConstructor
public class LectureController {

    private final LectureSevice lectureSevice;

    @GetMapping
    public List<LectureDto> getLectures() {
        return mapToLectureDtos(lectureSevice.getLectures());
    }

    @PostMapping
    public Lecture addLecture(@RequestBody Lecture lecture) {
        return lectureSevice.addLecture(lecture);
    }
}
