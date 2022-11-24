package com.jpa.jpaexercise.hospital.service;

import com.jpa.jpaexercise.hospital.domain.dto.ReviewAddRequest;
import com.jpa.jpaexercise.hospital.domain.dto.ReviewAddResponse;
import com.jpa.jpaexercise.hospital.domain.dto.ReviewResponse;
import com.jpa.jpaexercise.hospital.domain.entity.Hospital;
import com.jpa.jpaexercise.hospital.domain.entity.Review;
import com.jpa.jpaexercise.hospital.repository.HospitalRepository;
import com.jpa.jpaexercise.hospital.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;


    public ReviewService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }


    public List<ReviewResponse> getAllByHospital(Long id) {
        List<Review> reviews = reviewRepository.findAllByHospitalId(id);
        List<ReviewResponse> responseList = new ArrayList<>();
        for(Review review:reviews){
            responseList.add(ReviewResponse.builder()
                            .hospitalId(review.getHospital().getId())
                            .userName(review.getUserName())
                            .content(review.getContent())
                            .title(review.getTitle())
                            .id(review.getId())
                    .build());
        }
        return responseList;
    }
    public ReviewResponse getOneReview( Long reviewId){
        Optional<Review> opReview = reviewRepository.findById(reviewId);
        Review review = opReview.get();
        return ReviewResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .userName(review.getUserName())
                .hospitalId(review.getHospital().getId())
                .build();

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
