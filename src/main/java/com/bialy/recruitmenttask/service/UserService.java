package com.bialy.recruitmenttask.service;

import com.bialy.recruitmenttask.model.Lecture;
import com.bialy.recruitmenttask.model.User;
import com.bialy.recruitmenttask.model.Registration;
import com.bialy.recruitmenttask.repository.LectureRepository;
import com.bialy.recruitmenttask.repository.RegistrationRepository;
import com.bialy.recruitmenttask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;
    private final RegistrationRepository registrationRepository;

    //TODO take care of N + 1 problem

    public User updateEmail(long id, String email) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("Użytkownik o id: "+ id +" nie istnieje"));
        List<User> users = userRepository.findAll();
        if(email != null && email.length() > 0 && !user.getEmail().equals(email)) {
            users.forEach(user1 -> {
                if(user1.getEmail().equals(email))
                {
                    throw new IllegalArgumentException("Podany email jest zajęty");
                }
            });
            user.setEmail(email);
            return userRepository.save(user);
        }
        throw new IllegalArgumentException("Podano błędny email");
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
