package com.bialy.recruitmenttask.service;

import com.bialy.recruitmenttask.model.Registration;
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
}
