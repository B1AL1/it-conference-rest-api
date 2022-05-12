package com.bialy.recruitmenttask.service;

import com.bialy.recruitmenttask.model.Lecture;
import com.bialy.recruitmenttask.model.Registration;
import com.bialy.recruitmenttask.repository.LectureRepository;
import com.bialy.recruitmenttask.repository.RegistrationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class LectureSevice {

    private final LectureRepository lectureRepository;
    private final RegistrationRepository registrationRepository;

    public List<Lecture> getLectures() {
        return lectureRepository.findAll();
    }

    public List<Lecture> getUserLectures(String login) {
        return lectureRepository.findAllLecturesByUserLogin(login);
    }

    public List<Double> getPercentageParticipationRate() {
        List<Registration> registrations = registrationRepository.findAll();
        List<Lecture> lectures = getLectures();
        List<Double> ratio = new ArrayList<>();
        List<Integer> accumulator = new ArrayList<>();

        lectures.forEach(lecture -> {
            registrations.forEach(registration -> {
                if(registration.getLecture_id() == lecture.getId())
                    accumulator.add(1);
            });
            ratio.add( (double)accumulator.stream().count()/(double)lecture.getMax_amount_of_users());
            accumulator.clear();
        });
        return ratio;
    }

    public List<Double> getPercentageParticipationRateInPath() {
        List<Registration> registrations = registrationRepository.findAll();
        List<Lecture> lectures = getLectures();
        Set<Integer> paths = lectureRepository.findAllByThematic_path();
        List<Double> ratio = new ArrayList<>();
        List<Integer> accumulator = new ArrayList<>();
        List<Integer> divider = new ArrayList<>();

        paths.forEach(path -> {
            lectures.forEach(lecture -> {
                if(lecture.getThematic_path() == path)
                {
                    registrations.forEach(registration -> {
                        if(registration.getLecture_id() == lecture.getId())
                            accumulator.add(1);
                    });
                    divider.add(1);
                }
            });
            ratio.add( (double)accumulator.stream().count()/(double)(divider.stream().count() * 5));
            accumulator.clear();
            divider.clear();
        });

        return ratio;
    }
}
