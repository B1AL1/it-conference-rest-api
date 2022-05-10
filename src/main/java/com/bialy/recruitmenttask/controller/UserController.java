package com.bialy.recruitmenttask.controller;

import com.bialy.recruitmenttask.model.User;
import com.bialy.recruitmenttask.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id){
        return userService.getUser(id);
    }
}
