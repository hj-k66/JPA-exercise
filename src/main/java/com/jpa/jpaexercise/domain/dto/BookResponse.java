package com.jpa.jpaexercise.domain.dto;


import com.jpa.jpaexercise.domain.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {
    private Long id;
    private String name;
    private String authorName;
    private String publisherName;

    public static BookResponse of(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .authorName(book.getAuthor().getName())
                .publisherName(book.getPublisher().getName())
                .build();
    }
}
