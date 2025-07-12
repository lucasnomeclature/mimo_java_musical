package edu.mimo.books.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mimo.books.dto.AuthorCreationDto;
import edu.mimo.books.dto.AuthorDto;
import edu.mimo.books.dto.BookCreationDto;
import edu.mimo.books.dto.BookDto;
import edu.mimo.books.service.AuthorService;
import edu.mimo.books.service.BookService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    
    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping
    public List<AuthorDto> getAllBooks() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Integer id) {
        return authorService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/books")
    public List<BookDto> authorBooks(@PathVariable Integer id) {
        return bookService.byAuthorId(id);
    }

    @PostMapping
    public ResponseEntity<AuthorDto> newAuthor(@RequestBody AuthorCreationDto authorCreateDto) {
        return authorService.createAuthor(authorCreateDto)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound()
                .build());
    }
}
