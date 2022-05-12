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
        List<Registration> ids = registrationRepository.findAllByLecture_id(registration.getLecture_id());

        Lecture lecture = lectureRepository.findById(registration.getLecture_id()).orElseThrow();

        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        User exists = userRepository.findUserByLogin(user.getLogin());

        Registration newRegistration = new Registration();
        newRegistration.setLecture_id(registration.getLecture_id());
        newRegistration.setCreated(registration.getCreated());

        if(ids.stream().count()<lecture.getMax_amount_of_users())
        {
            if(!(exists == null))
            {
                if(exists.getLogin().equals(login) && !exists.getEmail().equals(email))
                {
                    throw new IllegalStateException("Podany login jest już zajęty");
                }
                else
                {
                    List<Registration> registrations = registrationRepository.findAllByUser_id(exists.getId());
                    registrations.forEach(registration1 -> {
                        if(registration1.getLecture_id() == registration.getLecture_id())
                        {
                            throw new IllegalArgumentException("Użytkownik jest już zapisany na tą prelekcję");
                        }
                    });

                    newRegistration.setUser_id(exists.getId());
                    return registrationRepository.save(newRegistration);
                }
            }
            else {
                userRepository.save(user);
                User newUser = userRepository.findUserByLogin(user.getLogin());
                newRegistration.setUser_id(newUser.getId());
                return registrationRepository.save(newRegistration);
            }
        }
        else
        {
            throw new IllegalArgumentException("Brak miejsc na wykład");
        }
    }
}
