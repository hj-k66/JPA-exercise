package com.jpa.jpaexercise.hospital.repository;

import com.jpa.jpaexercise.hospital.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
   List<Review> findAllByHospitalId(Long id);
}
