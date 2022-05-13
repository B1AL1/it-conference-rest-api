package com.bialy.recruitmenttask.service;

import com.bialy.recruitmenttask.model.Lecture;
import com.bialy.recruitmenttask.model.Registration;
import com.bialy.recruitmenttask.model.User;
import com.bialy.recruitmenttask.repository.LectureRepository;
import com.bialy.recruitmenttask.repository.RegistrationRepository;
import com.bialy.recruitmenttask.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@AllArgsConstructor
public class LectureSevice {

    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;
    private final RegistrationRepository registrationRepository;

    public List<Lecture> getLectures() {
        return lectureRepository.findAll();
    }

    public List<Lecture> getUserLectures(String login) {
        User user = userRepository.findUserByLogin(login);
        if(user == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Użytkownik o loginie: "+ login +" nie istnieje");
        }
        else
        {
            return lectureRepository.findAllLecturesByUserLogin(login);
        }
    }

    public Map<String, Object> getPercentageParticipationRate() {
        List<Registration> registrations = registrationRepository.findAll();
        List<Lecture> lectures = getLectures();
        Map<Long, Double> ratio = new HashMap<>();
        List<Integer> accumulator = new ArrayList<>();

        lectures.forEach(lecture -> {
            registrations.forEach(registration -> {
                if(registration.getLecture_id() == lecture.getId())
                    accumulator.add(1);
            });
            ratio.put(lecture.getId(), (double)accumulator.stream().count()/(double)lecture.getMax_amount_of_users());
            accumulator.clear();
        });
        JSONObject jsonObject = new JSONObject(ratio);

        return jsonObject.toMap();
    }

    public Map<String, Object> getPercentageParticipationRateInPath() {
        List<Registration> registrations = registrationRepository.findAll();
        List<Lecture> lectures = getLectures();
        Set<Integer> paths = lectureRepository.findAllByThematic_path();
        Map<Integer, Double> ratio = new HashMap<>();
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
            ratio.put(path, (double)accumulator.stream().count()/(double)(divider.stream().count() * 5));
            accumulator.clear();
            divider.clear();
        });
        JSONObject jsonObject = new JSONObject(ratio);

        return jsonObject.toMap();
    }
}
