package com.bialy.recruitmenttask.service;

import com.bialy.recruitmenttask.model.Lecture;
import com.bialy.recruitmenttask.model.Registration;
import com.bialy.recruitmenttask.model.User;
import com.bialy.recruitmenttask.repository.LectureRepository;
import com.bialy.recruitmenttask.repository.RegistrationRepository;
import com.bialy.recruitmenttask.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationService {

    public final RegistrationRepository registrationRepository;
    public final UserRepository userRepository;
    public final LectureRepository lectureRepository;

    public Registration registerUserToLecture(String login, String email, Registration registration) throws IOException {
        List<Registration> ids = registrationRepository.findAllByLecture_id(registration.getLecture_id());

        Lecture lecture = lectureRepository.findById(registration.getLecture_id()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prelekcja o id: "+ registration.getLecture_id() +" nie istnieje"));

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
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Podany login jest ju?? zaj??ty");
                }
                else
                {
                    List<Registration> registrations = registrationRepository.findAllByUser_id(exists.getId());
                    registrations.forEach(registration1 -> {
                        if(registration1.getLecture_id() == registration.getLecture_id())
                        {
                            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "U??ytkownik jest ju?? zapisany na t?? prelekcj??");
                        }
                        Lecture lecture1 = lectureRepository.findById(registration1.getLecture_id()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prelekcja o id: "+ registration1.getLecture_id() +" nie istnieje"));
                        if(lecture1.getStarting().equals(lecture.getStarting()))
                        {
                            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "U??ytkownik jest ju?? zapisany na inn?? prelekcj?? w tym samym czasie");
                        }
                    });
                    newRegistration.setUser_id(exists.getId());
                    saveToFile(LocalDateTime.now(), exists.getEmail(), lecture.getTitle());

                    return registrationRepository.save(newRegistration);
                }
            }
            else {
                userRepository.save(user);
                User newUser = userRepository.findUserByLogin(user.getLogin());
                newRegistration.setUser_id(newUser.getId());
                saveToFile(LocalDateTime.now(), newUser.getEmail(), lecture.getTitle());

                return registrationRepository.save(newRegistration);
            }
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Brak miejsc na wyk??ad");
        }
    }

    public void deleteRegistartion(long user_id, long lecture_id) {
        User user = userRepository.findById(user_id).orElseThrow(() -> new IllegalStateException("U??ytkownik o id: "+ user_id +" nie istnieje"));
        Registration registration = registrationRepository.findAllByUser_idAndLecture_id(user_id, lecture_id);

        if(registration == null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "U??ytkownik nie jest zapisany na t?? prelekcje");
        }
        if(registration.getLecture_id() == lecture_id && registration.getUser_id() == user_id)
        {
            registrationRepository.delete(registration);
        }
    }

    public void saveToFile(LocalDateTime dateTime, String email, String description){
        String filePath = "src/main/resources/emailmessage.txt";
        File file = new File(filePath);
        PrintWriter writer = null;
        String str = "Data wys??ania: " + dateTime + "\nDo: " + email + "\nTre????: Zapisano na przelekcj??: " + description;

        try {
            file.createNewFile();
            writer = new PrintWriter(file);
            writer.print(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Nie uda??o si?? zapisa?? powiadomienia do pliku");
        }
        writer.close();
    }
}
