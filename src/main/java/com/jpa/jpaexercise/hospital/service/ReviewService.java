package com.jpa.jpaexercise.hospital.service;

import com.jpa.jpaexercise.hospital.domain.dto.ReviewAddRequest;
import com.jpa.jpaexercise.hospital.domain.dto.ReviewAddResponse;
import com.jpa.jpaexercise.hospital.domain.entity.Hospital;
import com.jpa.jpaexercise.hospital.domain.entity.Review;
import com.jpa.jpaexercise.hospital.repository.HospitalRepository;
import com.jpa.jpaexercise.hospital.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;


    public ReviewService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    public ReviewAddResponse add(ReviewAddRequest request, Long hospitalId){
        Optional<Hospital> hospital = hospitalRepository.findById(hospitalId);
        Review review = Review.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .userName(request.getUserName())
                .hospital(hospital.get())
                .build();
        Review saveReview = reviewRepository.save(review);
        return ReviewAddResponse.builder()
                .id(saveReview.getId())
                .content(saveReview.getContent())
                .userName(saveReview.getUserName())
                .titile(saveReview.getTitle())
                .hospital_id(saveReview.getHospital().getId())
                .message("리뷰 등록에 성공했습니다.")
                .build();
    }



}
