package com.bialy.recruitmenttask.service;

import com.bialy.recruitmenttask.model.Lecture;
import com.bialy.recruitmenttask.model.Registration;
import com.bialy.recruitmenttask.model.User;
import com.bialy.recruitmenttask.repository.RegistrationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    public List<Registration> getRegistrations() {
        return registrationRepository.findAll();
    }

    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    public Registration addRegistration(Registration registration) {
        throw new IllegalArgumentException("NOT IMPLEMENTED");
    }
}
