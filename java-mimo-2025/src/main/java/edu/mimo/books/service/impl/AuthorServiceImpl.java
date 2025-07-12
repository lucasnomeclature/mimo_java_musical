package edu.mimo.books.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.mimo.books.dto.AuthorCreationDto;
import edu.mimo.books.dto.AuthorDto;
import edu.mimo.books.entity.Author;
import edu.mimo.books.mapper.AuthorMapper;
import edu.mimo.books.repository.AuthorRepository;
import edu.mimo.books.repository.CountryRepository;
import edu.mimo.books.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, 
                            AuthorMapper authorMapper, 
                            CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public Optional<AuthorDto> findById(Integer id) {
       return authorRepository.findById(id)
        .map(author -> authorMapper.toDto(author));
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return authorRepository.findAll()
        .stream()
        .map(author -> authorMapper.toDto(author))
        .toList();
    }

    @Override
    public Optional<AuthorDto> createAuthor(AuthorCreationDto dto) {
        return countryRepository.findById(dto.countryId())
        .map(country -> {
            Author toSave = new Author();
            toSave.setCountry(country);
            toSave.setName(dto.name());
            return authorRepository.save(toSave);
        }).map(author -> authorMapper.toDto(author));
    }
    
}
