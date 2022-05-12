package com.bialy.recruitmenttask.service;

import com.bialy.recruitmenttask.model.User;
import com.bialy.recruitmenttask.model.Registration;
import com.bialy.recruitmenttask.repository.LectureRepository;
import com.bialy.recruitmenttask.repository.RegistrationRepository;
import com.bialy.recruitmenttask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public boolean addUserIfNotExists(User user) {
        boolean exists = userRepository.findUserByLogin(user.getLogin());
        if(exists)
            throw new IllegalStateException("Podany login jest już zajęty");
        else {
            userRepository.save(user);
            return true;
        }
    }

    public boolean addUser(User user) {
        boolean exists = (userRepository.findUserByLogin(user.getLogin()) && lectureRepository.findAllByUserId(user.getId()));
        if(exists)
            throw new IllegalStateException("Podany login jest już zajęty");
        else {
            userRepository.save(user);
            return true;
        }
    }

    //TODO take care of N + 1 problem

    public List<User> getUsersWithRegistrations() {
        return userRepository.findAll();
    }

    public User getUserWithRegistrations(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public Registration registerUserToLecture(String login, String email) {
        return null;
    }
}
