package edu.mimo.books.mapper;

import java.util.Optional;

import org.springframework.stereotype.Component;

import edu.mimo.books.dto.AuthorSummaryDto;
import edu.mimo.books.dto.BookCreationDto;
import edu.mimo.books.dto.BookDto;
import edu.mimo.books.entity.Author;
import edu.mimo.books.entity.Musical;

@Component
public class BookMapper {
    public Musical toEntity(BookCreationDto dto) {
        Musical book = new Musical();
        book.setTitle(dto.getTitle());
        book.setOriginalLanguage(dto.getOriginalLanguage());
        book.setYear(dto.getYear());
        return book;
    }

    public BookDto toDto(Musical book) {
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setOriginalLanguage(book.getOriginalLanguage());
        dto.setYear(book.getYear());

        Author theAuthor = book.getAuthor();
        AuthorSummaryDto author = Optional.ofNullable(theAuthor)
        .map(a -> new AuthorSummaryDto(a.getId(), a.getName()))
        .orElse(AuthorSummaryDto.UNKNOWN_AUTHOR);

        dto.setAuthor(author);
        return dto;
    }
} 