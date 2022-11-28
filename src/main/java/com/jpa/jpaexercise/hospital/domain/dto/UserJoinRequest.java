package com.jpa.jpaexercise.hospital.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserJoinRequest {
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
}
