package edu.mimo.books.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import edu.mimo.books.dto.BookCreationDto;
import edu.mimo.books.dto.BookDto;

public interface BookService {
    List<BookDto> getAllBooks();
    Optional<BookDto> getBookById(Integer id);
    Optional<BookDto> createBook(BookCreationDto bookCreateDto);
    Optional<BookDto> updateBook(Integer id, BookCreationDto bookCreateDto);
    boolean deleteBook(Integer id);
    Map<String, List<BookDto>> groupBooksByLanguage();


     List<BookDto> byAuthorId(Integer authorId);
} 