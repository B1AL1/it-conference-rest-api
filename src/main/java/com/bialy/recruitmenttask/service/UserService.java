package com.bialy.recruitmenttask.service;

import com.bialy.recruitmenttask.model.Lecture;
import com.bialy.recruitmenttask.model.User;
import com.bialy.recruitmenttask.model.Registration;
import com.bialy.recruitmenttask.repository.LectureRepository;
import com.bialy.recruitmenttask.repository.RegistrationRepository;
import com.bialy.recruitmenttask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;
    private final RegistrationRepository registrationRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    //TODO take care of N + 1 problem

    public List<User> getUsersWithRegistrations() {
        return userRepository.findAll();
    }

    public User getUserWithRegistrations(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public Registration registerUserToLecture(String login, String email, Registration registration) {
        Long lecture_id = registrationRepository.findAllById(registration.getLecture_id());
        List<Lecture> lectures = lectureRepository.findAllById(registration.getLecture_id());
        User user = new User();
        user.setEmail(email);
        user.setLogin(login);
        User exists = userRepository.findUserByLogin(user.getLogin());
        if(lectures.stream().count()<5)
        {
            if(!(exists == null))
                throw new IllegalStateException("Podany login jest już zajęty");
            else {
                userRepository.save(user);
            }
        }
        throw new IllegalStateException("NOT IMPLEMENTED");
    }
}
