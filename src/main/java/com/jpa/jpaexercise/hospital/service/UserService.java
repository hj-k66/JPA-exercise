package com.jpa.jpaexercise.hospital.service;

import com.jpa.jpaexercise.configuration.EncrypterConfig;
import com.jpa.jpaexercise.hospital.domain.dto.UserDto;
import com.jpa.jpaexercise.hospital.domain.dto.UserJoinRequest;
import com.jpa.jpaexercise.hospital.domain.entity.User;
import com.jpa.jpaexercise.hospital.exception.ErrorCode;
import com.jpa.jpaexercise.hospital.exception.HospitalReviewException;
import com.jpa.jpaexercise.hospital.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserDto join(UserJoinRequest userJoinRequest){
        //중복 체크
        userRepository.findByUserName(userJoinRequest.getUserName())
                .ifPresent(user -> {
                    throw new HospitalReviewException(ErrorCode.DUPLICATED_USER_NAME, "해당 userName이 이미 존재합니다. 다시 작성해주세요.");
                });
        User user = userRepository.save(userJoinRequest.toEntity(encoder.encode(userJoinRequest.getPassword())));
        return UserDto.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
