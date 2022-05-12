package com.bialy.recruitmenttask.controller;

import com.bialy.recruitmenttask.model.Registration;
import com.bialy.recruitmenttask.service.RegistrationService;
import com.bialy.recruitmenttask.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/{login}/{email}")
    public Registration registerUserToLecture(@PathVariable String login, @PathVariable String email, @RequestBody Registration registration) throws IOException {
        return registrationService.registerUserToLecture(login, email, registration);
    }

    @DeleteMapping("/{user_id}")
    public void deleteRegistration(@PathVariable long user_id, @RequestParam long lecture_id) {
        registrationService.deleteRegistartion(user_id, lecture_id);
    }

}
