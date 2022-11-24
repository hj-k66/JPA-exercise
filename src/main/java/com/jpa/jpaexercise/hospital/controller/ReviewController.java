package com.jpa.jpaexercise.hospital.controller;

import com.jpa.jpaexercise.hospital.domain.dto.ReviewResponse;
import com.jpa.jpaexercise.hospital.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> getOneReview(@PathVariable Long id){
        ReviewResponse reviewResponse = reviewService.getOneReview(id);
        return ResponseEntity.ok().body(reviewResponse);
    }
}
