package com.jpa.jpaexercise.hospital.controller;

import com.jpa.jpaexercise.hospital.domain.dto.ReviewAddRequest;
import com.jpa.jpaexercise.hospital.domain.dto.ReviewAddResponse;
import com.jpa.jpaexercise.hospital.domain.dto.ReviewResponse;
import com.jpa.jpaexercise.hospital.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {
    private final ReviewService reviewService;

    public HospitalController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewResponse>> getAllReviewsByHospital(@PathVariable Long id){
        List<ReviewResponse> allReviews = reviewService.getAllByHospital(id);
        return ResponseEntity.ok().body(allReviews);
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewAddResponse> createReview(@PathVariable Long id, @RequestBody ReviewAddRequest request){
        return ResponseEntity.ok().body(reviewService.add(request, id));

    }
}
