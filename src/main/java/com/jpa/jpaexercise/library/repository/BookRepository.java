package com.jpa.jpaexercise.library.repository;

import com.jpa.jpaexercise.library.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
