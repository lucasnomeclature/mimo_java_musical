package edu.mimo.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mimo.books.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{
    
}
