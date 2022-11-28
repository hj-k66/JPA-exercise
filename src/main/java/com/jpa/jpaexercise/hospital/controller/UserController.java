package com.jpa.jpaexercise.hospital.controller;

import com.jpa.jpaexercise.hospital.domain.dto.Response;
import com.jpa.jpaexercise.hospital.domain.dto.UserDto;
import com.jpa.jpaexercise.hospital.domain.dto.UserJoinRequest;
import com.jpa.jpaexercise.hospital.domain.dto.UserJoinResponse;
import com.jpa.jpaexercise.hospital.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest userJoinRequest){
        UserDto userDto = userService.join(userJoinRequest);
        return Response.success(new UserJoinResponse(userDto.getUserName(), userDto.getPhoneNumber(), userDto.getEmail()));
    }
}
