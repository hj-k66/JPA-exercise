package com.jpa.jpaexercise.hospital.service;

import com.jpa.jpaexercise.hospital.domain.dto.UserDto;
import com.jpa.jpaexercise.hospital.domain.dto.UserJoinRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserDto join(UserJoinRequest userJoinRequest){
        return new UserDto("","","","");
    }
}
