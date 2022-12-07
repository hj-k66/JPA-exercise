package com.jpa.jpaexercise.hospital.domain.dto;

import com.jpa.jpaexercise.hospital.domain.dto.review.ReviewResponse;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class HospitalResponse {
    private Long id;
    private String roadNameAddress;
    private String hospitalName;
    private List<ReviewResponse> reviews;
}
