package com.bialy.recruitmenttask.service;

import com.bialy.recruitmenttask.model.User;
import com.bialy.recruitmenttask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
