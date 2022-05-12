package com.bialy.recruitmenttask.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String login;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private List<Registration> registration;
}
