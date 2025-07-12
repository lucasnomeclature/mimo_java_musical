package edu.mimo.books.controller;

import edu.mimo.books.service.BookService;
import edu.mimo.books.dto.BookCreationDto;
import edu.mimo.books.dto.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") Integer id) {
        return bookService.getBookById(id)
                .map(bookDto -> ResponseEntity.ok(bookDto))
                .orElseGet(() -> ResponseEntity.notFound()
                        .header("reason", "book not found")
                        .build()
                );
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookCreationDto bookCreateDto) {
        return bookService.createBook(bookCreateDto)
                .map(bookDto -> ResponseEntity.ok(bookDto))
                .orElseGet(() -> ResponseEntity.notFound().build()                        
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Integer id, @RequestBody BookCreationDto bookCreateDto) {
        return bookService.updateBook(id, bookCreateDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        if (bookService.deleteBook(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/books-by-language")
    public Map<String, List<BookDto>> groupBooksByLanguage() {
        return bookService.groupBooksByLanguage();
    }
} 