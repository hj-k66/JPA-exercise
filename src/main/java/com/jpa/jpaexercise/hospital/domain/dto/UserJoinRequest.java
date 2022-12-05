package com.jpa.jpaexercise.hospital.domain.dto;

import com.jpa.jpaexercise.hospital.domain.UserRole;
import com.jpa.jpaexercise.hospital.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserJoinRequest {
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;

    public User  toEntity(String password){
        return User.builder()
                .userName(this.userName)
                .password(password)
                .phoneNumber(this.phoneNumber)
                .email(this.email)
                .role(UserRole.USER)  //default=USER
                .build();
    }
}
