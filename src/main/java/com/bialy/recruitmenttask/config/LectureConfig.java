package com.bialy.recruitmenttask.config;

import com.bialy.recruitmenttask.model.Lecture;
import com.bialy.recruitmenttask.model.Registration;
import com.bialy.recruitmenttask.service.RegistrationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class LectureConfig {

    @Bean
    CommandLineRunner commandLineRunner(RegistrationService registrationService)
    {
        return args -> {
            Lecture lecture1 = new Lecture(
                    1L,
                    "Jak dostać 1 pracę?",
                    LocalDate.of(2021, Month.JUNE, 1).atTime(9, 0),
                    registrationService.getRegistrations()
            );

            Lecture lecture2 = new Lecture(
                    2L,
                    "Jak dostać 1 pracę?",
                    LocalDate.of(2021, Month.JUNE, 1).atTime(9, 0),
                    registrationService.getRegistrations()
            );
            Lecture lecture3 = new Lecture(
                    1L,
                    "Jak dostać 1 pracę?",
                    LocalDate.of(2021, Month.JUNE, 1).atTime(9, 0),
                    registrationService.getRegistrations()
            );
            Lecture lecture4 = new Lecture(
                    1L,
                    "Jak dostać 1 pracę?",
                    LocalDate.of(2021, Month.JUNE, 1).atTime(9, 0),
                    registrationService.getRegistrations()
            );
            Lecture lecture5 = new Lecture(
                    1L,
                    "Jak dostać 1 pracę?",
                    LocalDate.of(2021, Month.JUNE, 1).atTime(9, 0),
                    registrationService.getRegistrations()
            );
            Lecture lecture6 = new Lecture(
                    1L,
                    "Jak dostać 1 pracę?",
                    LocalDate.of(2021, Month.JUNE, 1).atTime(9, 0),
                    registrationService.getRegistrations()
            );
            Lecture lecture7 = new Lecture(
                    1L,
                    "Jak dostać 1 pracę?",
                    LocalDate.of(2021, Month.JUNE, 1).atTime(9, 0),
                    registrationService.getRegistrations()
            );
            Lecture lecture8 = new Lecture(
                    1L,
                    "Jak dostać 1 pracę?",
                    LocalDate.of(2021, Month.JUNE, 1).atTime(9, 0),
                    registrationService.getRegistrations()
            );
            Lecture lecture9 = new Lecture(
                    1L,
                    "Jak dostać 1 pracę?",
                    LocalDate.of(2021, Month.JUNE, 1).atTime(9, 0),
                    registrationService.getRegistrations()
            );
        };
    }

}
