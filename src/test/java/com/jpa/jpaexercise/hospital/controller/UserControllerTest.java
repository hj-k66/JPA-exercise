package com.jpa.jpaexercise.hospital.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.jpaexercise.hospital.domain.dto.UserJoinRequest;
import com.jpa.jpaexercise.hospital.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    @MockBean
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("회원가입 성공")
    void join_success(){
    }

}