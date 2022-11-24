package com.jpa.jpaexercise.hospital.service;

import com.jpa.jpaexercise.hospital.repository.HospitalRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

}
