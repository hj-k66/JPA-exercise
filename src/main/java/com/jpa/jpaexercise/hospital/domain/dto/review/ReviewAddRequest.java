package com.jpa.jpaexercise.hospital.domain.dto.review;

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
