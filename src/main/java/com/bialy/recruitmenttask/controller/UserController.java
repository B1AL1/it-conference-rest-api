package com.bialy.recruitmenttask.controller;

import com.bialy.recruitmenttask.model.*;
import com.bialy.recruitmenttask.service.LectureSevice;
import com.bialy.recruitmenttask.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bialy.recruitmenttask.controller.LectureDtoMapper.mapToLecturesDto;
import static com.bialy.recruitmenttask.controller.UserDtoMapper.mapToUserDtos;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final LectureSevice lectureSevice;


    @GetMapping("/{login}/lectures")
    public List<LectureDto> getUserLectures(@PathVariable String login){
        return mapToLecturesDto(lectureSevice.getUserLectures(login));
    }

    @PutMapping("/{id}")
    public User updateEmail(@PathVariable long id, @RequestParam String email) {
        return userService.updateEmail(id, email);
    }

    @GetMapping
    public List<UserDto> getUsers(){
        return mapToUserDtos(userService.getUsers());
    }


}
