package com.bialy.recruitmenttask.controller;

import com.bialy.recruitmenttask.model.Lecture;
import com.bialy.recruitmenttask.model.Registration;
import com.bialy.recruitmenttask.model.User;
import com.bialy.recruitmenttask.model.UserDto;
import com.bialy.recruitmenttask.service.LectureSevice;
import com.bialy.recruitmenttask.service.RegistrationService;
import com.bialy.recruitmenttask.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<UserDto> getUsers(){ return mapToUserDtos(userService.getUsers()); }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable long id){
        return mapToUserDto(userService.getUser(id));
    }

    @GetMapping("/withregistrations")
    public List<User> getUsersWithRegistrations(){
        return userService.getUsers();
    }

    @GetMapping("/withregistrations/{id}")
    public User getUserWithRegistrations(@PathVariable long id){
        return userService.getUser(id);
    }

    @GetMapping("/{login}/lectures")
    public List<Lecture> getUserLectures(@PathVariable String login){
        return lectureSevice.getUserLectures(login);
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user) { userService.addNewUser(user); }

    @PostMapping("/test")
    public void registerUserToLecture(@RequestBody User user, @RequestBody Registration registration) {
        if(userService.addUserIfNotExists(user))
            registrationService.saveRegistration(registration);
    }
}
