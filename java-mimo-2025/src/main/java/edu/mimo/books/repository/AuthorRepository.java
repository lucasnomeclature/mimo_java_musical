package edu.mimo.books.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mimo.books.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
    
    //@EntityGraph(attributePaths = {"country"})
    Optional<Author> findById(Integer id);

}
