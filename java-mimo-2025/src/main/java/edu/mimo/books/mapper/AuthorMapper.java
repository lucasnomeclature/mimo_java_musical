package edu.mimo.books.mapper;

import org.springframework.stereotype.Component;

import edu.mimo.books.dto.AuthorDto;
import edu.mimo.books.dto.CountryDto;
import edu.mimo.books.entity.Author;

@Component
public class AuthorMapper {
   
    public AuthorDto toDto(Author entity) {
        CountryDto countryDto = new CountryDto(
                entity.getCountry().getId(), 
                entity.getCountry().getName()
            );
        return new AuthorDto(entity.getId(), entity.getName(), countryDto);
    }
}
