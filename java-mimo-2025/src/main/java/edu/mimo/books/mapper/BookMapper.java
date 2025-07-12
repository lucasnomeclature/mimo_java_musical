package edu.mimo.books.mapper;

import java.util.Optional;

import org.springframework.stereotype.Component;

import edu.mimo.books.dto.AuthorSummaryDto;
import edu.mimo.books.dto.BookCreationDto;
import edu.mimo.books.dto.BookDto;
import edu.mimo.books.entity.Author;
import edu.mimo.books.entity.Book;

@Component
public class BookMapper {
    public Book toEntity(BookCreationDto dto) {
        Book book = new Book();
        book.setIsbn(dto.getIsbn());
        book.setTitle(dto.getTitle());
        book.setOriginalLanguage(dto.getOriginalLanguage());
        book.setYear(dto.getYear());
        return book;
    }

    public BookDto toDto(Book book) {
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setIsbn(book.getIsbn());
        dto.setTitle(book.getTitle());
        dto.setOriginalLanguage(book.getOriginalLanguage());
        dto.setYear(book.getYear());

        Author theAuthor = book.getAuthor();
        AuthorSummaryDto author = Optional.ofNullable(theAuthor)
        .map(a -> new AuthorSummaryDto(a.getId(), a.getName()))
        .orElse(AuthorSummaryDto.UNKNOWN_AUTHOR);

        String authorCountry = Optional.ofNullable(book.getAuthor())
        .map(a -> a.getCountry())
        .map(country -> country.getName())
        .orElse("Unknown Country");

        dto.setAuthor(author);
        dto.setCountry(authorCountry);
        return dto;
    }
} 