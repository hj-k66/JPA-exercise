package com.jpa.jpaexercise.hospital.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserJoinResponse {
    private String userName;
    private String phoneNumber;
    private String email;
}
