package com.jpa.jpaexercise.hospital.domain.dto;

import com.jpa.jpaexercise.hospital.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserJoinRequest {
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;

    public User toEntity(){
        return User.builder()
                .userName(this.userName)
                .password(this.password)
                .phoneNumber(this.phoneNumber)
                .email(this.email)
                .build();
    }
}
