package com.bialy.recruitmenttask.service;

import com.bialy.recruitmenttask.model.User;
import com.bialy.recruitmenttask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //TODO take care of N + 1 problem

    public User updateEmail(long id, String email) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Użytkownik o id: "+ id +" nie istnieje"));
        List<User> users = userRepository.findAll();
        if(email != null && email.length() > 0 && !user.getEmail().equals(email)) {
            users.forEach(user1 -> {
                if(user1.getEmail().equals(email))
                {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Podany email jest zajęty");
                }
            });
            user.setEmail(email);
            return userRepository.save(user);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Podano błędny email");
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
