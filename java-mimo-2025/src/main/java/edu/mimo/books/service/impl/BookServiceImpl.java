package edu.mimo.books.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mimo.books.dto.BookCreationDto;
import edu.mimo.books.dto.BookDto;
import edu.mimo.books.entity.Author;
import edu.mimo.books.entity.Book;
import edu.mimo.books.mapper.BookMapper;
import edu.mimo.books.repository.AuthorRepository;
import edu.mimo.books.repository.BookRepository;
import edu.mimo.books.service.BookService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, 
                           BookMapper bookMapper, 
                           AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> dtos = new ArrayList<>();
        for (Book book : books) {
            BookDto dto = bookMapper.toDto(book);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public List<BookDto> byAuthorId(Integer authorId) {
        List<Book> books = bookRepository.findByAuthorId(authorId);
        List<BookDto> dtos = new ArrayList<>();
        for (Book book : books) {
            BookDto dto = bookMapper.toDto(book);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public Optional<BookDto> getBookById(Integer id) {
        return bookRepository.findById(id)
                    .map(entity -> bookMapper.toDto(entity));
    }

    @Override
    public Optional<BookDto> createBook(BookCreationDto bookCreateDto) {
        return authorRepository.findById(bookCreateDto.getAuthorId())
        .map(author -> {
            Book book = bookMapper.toEntity(bookCreateDto);
            book.setAuthor(author);
            Book saved = bookRepository.save(book);
            return bookMapper.toDto(saved);
        });
    }

    @Override
    public Optional<BookDto> updateBook(Integer id, BookCreationDto bookCreateDto) {
        return bookRepository.findById(id)
        .map(existing -> {
            Book toUpdate = bookMapper.toEntity(bookCreateDto);
            toUpdate.setId(id);
            Author author = authorRepository.findById(bookCreateDto.getAuthorId())
            .orElse(existing.getAuthor());
            toUpdate.setAuthor(author);
            Book saved = bookRepository.save(toUpdate);
            return bookMapper.toDto(saved);
        });
    }

    @Override
    public boolean deleteBook(Integer id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Map<String, List<BookDto>> groupBooksByLanguage() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .collect(Collectors.groupingBy(BookDto::getOriginalLanguage));//TODO check this in class
    }

} 