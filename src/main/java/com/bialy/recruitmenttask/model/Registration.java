package com.bialy.recruitmenttask.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Registration {
    @Id
    private long id;
    private long lecture_id;
    private LocalDateTime created;
}
