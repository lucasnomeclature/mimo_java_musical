package edu.mimo.books.repository;

import edu.mimo.books.entity.Musical;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Musical, Integer> {

    //@EntityGraph(attributePaths = {"author"})
    Optional<Musical> findById(Integer id);

    List<Musical> findByAuthorId(Integer authorId);



} 