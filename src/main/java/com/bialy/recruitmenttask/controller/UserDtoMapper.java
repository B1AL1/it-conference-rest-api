package com.bialy.recruitmenttask.controller;

import com.bialy.recruitmenttask.model.User;
import com.bialy.recruitmenttask.model.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserDtoMapper {

    private UserDtoMapper(){}

    public static List<UserDto> mapToUserDtos(List<User> users) {
        return users.stream()
                .map(user -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    public static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .login(user.getLogin())
                .build();
    }
}
