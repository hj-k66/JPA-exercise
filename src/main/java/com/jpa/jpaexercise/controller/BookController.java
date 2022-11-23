package com.jpa.jpaexercise.controller;

import com.jpa.jpaexercise.domain.dto.BookResponse;
import com.jpa.jpaexercise.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
public class BookController {
   private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/list")
    public ResponseEntity<List<BookResponse>> getList(Pageable pageable){
        List<BookResponse> all = bookService.getAll(pageable);
        return ResponseEntity.ok().body(all);
    }

}
