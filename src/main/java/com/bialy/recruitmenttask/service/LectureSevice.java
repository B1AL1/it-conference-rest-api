package com.bialy.recruitmenttask.service;

import com.bialy.recruitmenttask.model.Lecture;
import com.bialy.recruitmenttask.model.User;
import com.bialy.recruitmenttask.repository.LectureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LectureSevice {

    private final LectureRepository lectureRepository;

    public List<Lecture> getLectures() {
        return lectureRepository.findAll();
    }

    public List<Lecture> getUserLectures(String login) {
        return lectureRepository.findAllLecturesByUserLogin(login);
    }
}
