package com.jpa.jpaexercise.domain.dto;


import com.jpa.jpaexercise.domain.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private Long id;
    private String name;
    private String authorName;

    public static BookResponse of(Book book){
        return new BookResponse(book.getId(), book.getName(), book.getAuthor().getName());
    }
}
