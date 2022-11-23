package com.jpa.jpaexercise.service;

import com.jpa.jpaexercise.domain.dto.BookResponse;
import com.jpa.jpaexercise.domain.entity.Book;
import com.jpa.jpaexercise.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponse> getAll(Pageable pageable){
        Page<Book> books = bookRepository.findAll(pageable);
        List<BookResponse> bookResponseList = new ArrayList<>();
        for(Book book : books){
            bookResponseList.add(BookResponse.of(book));
        }
        return bookResponseList;
    }
}
