package com.jpa.jpaexercise.hospital.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.jpaexercise.hospital.domain.dto.user.UserDto;
import com.jpa.jpaexercise.hospital.domain.dto.user.UserJoinRequest;
import com.jpa.jpaexercise.hospital.domain.dto.user.UserLoginRequest;
import com.jpa.jpaexercise.hospital.exception.ErrorCode;
import com.jpa.jpaexercise.hospital.exception.HospitalReviewException;
import com.jpa.jpaexercise.hospital.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("회원가입 성공")
    @WithMockUser
    void join_success() throws Exception {
        UserJoinRequest userJoinRequest = UserJoinRequest.builder()
                .userName("kim")
                .password("asdf")
                .email("asdf@naver.com")
                .build();

        when(userService.join(any())).thenReturn(mock(UserDto.class));

        mockMvc.perform(post("/api/v1/users/join")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(userJoinRequest)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("회원가입 실패")
    @WithMockUser
    void join_failed() throws Exception {
        UserJoinRequest userJoinRequest = UserJoinRequest.builder()
                .userName("kim")
                .password("asdf")
                .email("asdf@naver.com")
                .build();

        when(userService.join(any())).thenThrow(new HospitalReviewException(ErrorCode.DUPLICATED_USER_NAME, ""));

        mockMvc.perform(post("/api/v1/users/join")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(userJoinRequest)))
                .andDo(print())
                .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("로그인 실패 - id없음")
    @WithMockUser
    void login_fail_id() throws Exception{
        //id, pw를 보내서 - LoginRequest
        UserLoginRequest userLoginRequest = UserLoginRequest.builder()
                .userName("id1")
                .password("asdf")
                .build();

        when(userService.login(any(),any())).thenThrow(new HospitalReviewException(ErrorCode.NOT_FOUND,""));

        mockMvc.perform(post("/api/v1/users/login")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(userLoginRequest)))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}