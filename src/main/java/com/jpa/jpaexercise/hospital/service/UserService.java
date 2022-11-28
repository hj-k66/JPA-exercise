package com.jpa.jpaexercise.hospital.service;

import com.jpa.jpaexercise.hospital.domain.dto.UserDto;
import com.jpa.jpaexercise.hospital.domain.dto.UserJoinRequest;
import com.jpa.jpaexercise.hospital.domain.entity.User;
import com.jpa.jpaexercise.hospital.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto join(UserJoinRequest userJoinRequest){
        //중복 체크
        userRepository.findByUserName(userJoinRequest.getUserName())
                .ifPresent(user -> {
                    throw new RuntimeException("해당 userName이 중복 됩니다.");
                });
        User user = userRepository.save(userJoinRequest.toEntity());
        return UserDto.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
