package com.bialy.recruitmenttask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private LocalDateTime starting;
    private LocalDateTime ending;

    @OneToMany
    @JoinColumn(name = "lecture_id")
    private List<Registration> registrations;
}
