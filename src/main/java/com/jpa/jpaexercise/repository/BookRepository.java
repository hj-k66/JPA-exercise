package com.jpa.jpaexercise.repository;

import com.jpa.jpaexercise.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
