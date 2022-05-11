package com.bialy.recruitmenttask.controller;

import com.bialy.recruitmenttask.model.Lecture;
import com.bialy.recruitmenttask.service.LectureSevice;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lecture")
@AllArgsConstructor
public class LectureController {

    private final LectureSevice lectureSevice;

    @GetMapping("/")
    public List<Lecture> getLectures() { return lectureSevice.getLectures(); }
}
