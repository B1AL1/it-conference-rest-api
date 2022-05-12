package com.bialy.recruitmenttask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private LocalDateTime starting;
    private LocalDateTime ending;
    private final int max_amount_of_users = 5;
    private int thematic_path;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecture_id", updatable = false, insertable = false)
    private List<Registration> registrations;
}
