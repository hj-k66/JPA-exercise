package com.jpa.jpaexercise.hospital.repository;

import com.jpa.jpaexercise.hospital.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
}
