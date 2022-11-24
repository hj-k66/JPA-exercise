package com.jpa.jpaexercise.hospital.domain.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewAddRequest {
    private String title;
    private  String content;
    private String userName;


}
