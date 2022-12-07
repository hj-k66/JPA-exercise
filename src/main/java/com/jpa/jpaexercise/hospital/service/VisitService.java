package com.jpa.jpaexercise.hospital.service;

import com.jpa.jpaexercise.hospital.domain.dto.visit.VisitCreateRequest;
import com.jpa.jpaexercise.hospital.domain.dto.visit.VisitCreateResponse;
import com.jpa.jpaexercise.hospital.domain.entity.Hospital;
import com.jpa.jpaexercise.hospital.domain.entity.User;
import com.jpa.jpaexercise.hospital.domain.entity.Visit;
import com.jpa.jpaexercise.hospital.exception.ErrorCode;
import com.jpa.jpaexercise.hospital.exception.HospitalReviewException;
import com.jpa.jpaexercise.hospital.repository.HospitalRepository;
import com.jpa.jpaexercise.hospital.repository.UserRepository;
import com.jpa.jpaexercise.hospital.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final VisitRepository visitRepository;
    private final UserRepository userRepository;
    private final HospitalRepository hospitalRepository;
    public VisitCreateResponse create(VisitCreateRequest visitCreateRequest, String userName){
        User user  = userRepository.findByUserName(userName)
                .orElseThrow(()-> new HospitalReviewException(ErrorCode.NOT_FOUND,""));
        Hospital hospital = hospitalRepository.findById(visitCreateRequest.getHospitalId())
                .orElseThrow(()->new HospitalReviewException(ErrorCode.NOT_FOUND,""));

        Visit visit = Visit.builder()
                .hospital(hospital)
                .payment(visitCreateRequest.getPayment())
                .disease(visitCreateRequest.getDisease())
                .createDateTime(LocalDate.now())
                .user(user)
                .build();
        visitRepository.save(visit);
        return new VisitCreateResponse("방문 기록 등록에 성공했습니다.");
    }
}
