package com.jpa.jpaexercise.library.repository;


import com.jpa.jpaexercise.library.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
