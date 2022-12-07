package com.jpa.jpaexercise.hospital.controller;

import com.jpa.jpaexercise.hospital.domain.dto.visit.VisitCreateRequest;
import com.jpa.jpaexercise.hospital.domain.dto.visit.VisitCreateResponse;
import com.jpa.jpaexercise.hospital.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/visits")
@RequiredArgsConstructor
public class VisitController {
    private final VisitService visitService;

    @PostMapping()
    public ResponseEntity<VisitCreateResponse> createVisit(@RequestBody VisitCreateRequest visitCreateRequest, Authentication authentication){
        VisitCreateResponse visitCreateResponse = visitService.create(visitCreateRequest, authentication.getName());
        return ResponseEntity.ok().body(visitCreateResponse);
    }
}
