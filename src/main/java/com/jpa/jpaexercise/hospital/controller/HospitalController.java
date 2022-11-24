package com.jpa.jpaexercise.hospital.controller;

import com.jpa.jpaexercise.hospital.domain.dto.ReviewAddRequest;
import com.jpa.jpaexercise.hospital.domain.dto.ReviewAddResponse;
import com.jpa.jpaexercise.hospital.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {
    private final ReviewService reviewService;

    public HospitalController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewAddResponse> createReview(@PathVariable Long id, @RequestBody ReviewAddRequest request){
        return ResponseEntity.ok().body(reviewService.add(request, id));

    }
}
