package com.jpa.jpaexercise.hospital.domain.dto.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewAddResponse {
    private Long id;
    private String titile;
    private  String content;
    private String userName;
    private Long hospital_id;
    private String message;

}
