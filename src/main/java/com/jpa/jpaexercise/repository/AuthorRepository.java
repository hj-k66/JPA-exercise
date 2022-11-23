package com.jpa.jpaexercise.repository;

import com.jpa.jpaexercise.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
