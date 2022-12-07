package com.jpa.jpaexercise.hospital.domain.dto.visit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitResponse {
    private Long id;
    private LocalDate createDateTime;
    private String disease;
    private Long payment;
    private String userName;
    private String hospitalName;
}
