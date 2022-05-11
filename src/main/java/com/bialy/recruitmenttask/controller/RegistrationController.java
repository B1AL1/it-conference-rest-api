package com.bialy.recruitmenttask.controller;

import com.bialy.recruitmenttask.model.Registration;
import com.bialy.recruitmenttask.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping
    public List<Registration> getRegistrations() { return registrationService.getRegistrations();}

}
