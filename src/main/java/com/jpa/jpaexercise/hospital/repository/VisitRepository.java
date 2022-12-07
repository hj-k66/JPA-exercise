package com.jpa.jpaexercise.hospital.repository;

import com.jpa.jpaexercise.hospital.domain.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit,Long> {
}
