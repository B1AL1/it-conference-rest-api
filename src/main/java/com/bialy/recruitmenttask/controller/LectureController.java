package com.bialy.recruitmenttask.controller;

import com.bialy.recruitmenttask.model.LectureDto;
import com.bialy.recruitmenttask.service.LectureSevice;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.bialy.recruitmenttask.controller.LectureDtoMapper.mapToLecturesDto;

@RestController
@RequestMapping("/api/v1/lecture")
@AllArgsConstructor
public class LectureController {

    private final LectureSevice lectureSevice;

    @GetMapping
    public List<LectureDto> getLectures(){
        return mapToLecturesDto(lectureSevice.getLectures());
    }

    @GetMapping("/statistic/all")
    public Map<String, Object> getPercentageParticipatationRate() {
        return lectureSevice.getPercentageParticipationRate();
    }

    @GetMapping("/statistic/path")
    public Map<String, Object> getPercentageParticipatationRateInPath() {
        return lectureSevice.getPercentageParticipationRateInPath();
    }

}
