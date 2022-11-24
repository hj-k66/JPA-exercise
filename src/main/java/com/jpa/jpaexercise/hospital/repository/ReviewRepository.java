package com.jpa.jpaexercise.hospital.repository;

import com.jpa.jpaexercise.hospital.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
