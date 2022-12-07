package com.jpa.jpaexercise.hospital.domain.dto.visit;

import lombok.Getter;

@Getter
public class VisitCreateRequest {
    private Long hospitalId;
    private String disease;
    private Long payment;
}
