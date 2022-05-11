package com.bialy.recruitmenttask.model;

import lombok.*;

@Getter
@Builder
public class UserDto {
    private long id;
    private String email;
    private String login;
}
