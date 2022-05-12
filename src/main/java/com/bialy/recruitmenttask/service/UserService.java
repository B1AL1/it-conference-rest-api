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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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

    public Registration registerUserToLecture(String login, String email, Registration registration) throws IOException {
        List<Registration> ids = registrationRepository.findAllByLecture_id(registration.getLecture_id());

        Lecture lecture = lectureRepository.findById(registration.getLecture_id()).orElseThrow();

        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        User exists = userRepository.findUserByLogin(user.getLogin());

        Registration newRegistration = new Registration();
        newRegistration.setLecture_id(registration.getLecture_id());
        newRegistration.setCreated(registration.getCreated());

        String filePath = "src/main/resources/emailmessage.txt";
        File file = new File(filePath);
        file.createNewFile();

        PrintWriter writer = null;


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
                        Lecture lecture1 = lectureRepository.findById(registration1.getLecture_id()).orElseThrow();
                        if(lecture1.getStarting().equals(lecture.getStarting()))
                        {
                            throw new IllegalArgumentException("Użytkownik jest już zapisany na inną prelekcję w tym samym czasie");
                        }
                    });

                    newRegistration.setUser_id(exists.getId());

                    String str = "Data wysłania: " + LocalDateTime.now()
                            + "\nDo: " + exists.getLogin()
                            + "\nTreść: Zapisano na przelekcję: " + lecture.getTitle();

                    try {
                        writer = new PrintWriter(file);
                        writer.print(str);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    writer.close();

                    return registrationRepository.save(newRegistration);
                }
            }
            else {
                userRepository.save(user);
                User newUser = userRepository.findUserByLogin(user.getLogin());
                newRegistration.setUser_id(newUser.getId());

                String str = "Data wysłania: " + LocalDateTime.now()
                        + "\nDo: " + newUser.getLogin()
                        + "\nTreść: Zapisano na przelekcję: " + lecture.getTitle();

                try {
                    writer = new PrintWriter(file);
                    writer.print(str);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                writer.close();

                return registrationRepository.save(newRegistration);
            }
        }
        else
        {
            throw new IllegalArgumentException("Brak miejsc na wykład");
        }
    }

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

    public void deleteRegistartion(long user_id, long lecture_id) {
        User user = userRepository.findById(user_id).orElseThrow(() -> new IllegalStateException("Użytkownik o id: "+ user_id +" nie istnieje"));
        Registration registration = registrationRepository.findAllByUser_idAndLecture_id(user_id, lecture_id);

        if(registration == null)
        {
            throw new IllegalArgumentException("Użytkownik nie jest zapisany na tą prelekcje");
        }

        if(registration.getLecture_id() == lecture_id && registration.getUser_id() == user_id)
        {
            registrationRepository.delete(registration);
        }


    }
}
