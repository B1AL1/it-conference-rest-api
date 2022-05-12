package com.bialy.recruitmenttask.controller;

import com.bialy.recruitmenttask.model.*;
import com.bialy.recruitmenttask.service.LectureSevice;
import com.bialy.recruitmenttask.service.RegistrationService;
import com.bialy.recruitmenttask.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bialy.recruitmenttask.controller.LectureDtoMapper.mapToLectureDto;
import static com.bialy.recruitmenttask.controller.LectureDtoMapper.mapToLecturesDto;
import static com.bialy.recruitmenttask.controller.UserDtoMapper.mapToUserDto;
import static com.bialy.recruitmenttask.controller.UserDtoMapper.mapToUserDtos;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final LectureSevice lectureSevice;
    private final RegistrationService registrationService;

    @GetMapping
    public List<UserDto> getUsers(){
        return mapToUserDtos(userService.getUsers());
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable long id){
        return mapToUserDto(userService.getUser(id));
    }

    @GetMapping("/registrations")
    public List<User> getUsersWithRegistrations(){
        return userService.getUsersWithRegistrations();
    }

    @GetMapping("/registrations/{id}")
    public User getUserWithRegistrations(@PathVariable long id){
        return userService.getUserWithRegistrations(id);
    }

    @GetMapping("/{login}/lectures")
    public List<LectureDto> getUserLectures(@PathVariable String login){
        return mapToLecturesDto(lectureSevice.getUserLectures(login));
    }

    @PostMapping("/{login}/{email}")
    public Registration registerUserToLecture(@PathVariable String login, @PathVariable String email, @RequestBody Registration registration) {
        return userService.registerUserToLecture(login, email, registration);
    }
}
