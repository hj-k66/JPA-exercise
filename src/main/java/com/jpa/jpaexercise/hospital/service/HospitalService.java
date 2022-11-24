package com.jpa.jpaexercise.hospital.service;

import com.jpa.jpaexercise.hospital.domain.dto.HospitalResponse;
import com.jpa.jpaexercise.hospital.domain.entity.Hospital;
import com.jpa.jpaexercise.hospital.repository.HospitalRepository;
import com.jpa.jpaexercise.hospital.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public HospitalService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    public HospitalResponse getHospitalWithReviews(Long id){
        Optional<Hospital> opHospital = hospitalRepository.findById(id);
        Hospital hospital = opHospital.get();
        return HospitalResponse.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .build();
    }

}
