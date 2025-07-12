package edu.mimo.books.service;

import java.util.List;
import java.util.Optional;

import edu.mimo.books.dto.AuthorCreationDto;
import edu.mimo.books.dto.AuthorDto;

public interface AuthorService {
    Optional<AuthorDto> findById(Integer id);
    List<AuthorDto> getAllAuthors();
    Optional<AuthorDto> createAuthor(AuthorCreationDto dto);
}
