package edu.mimo.books.dto;

public record AuthorSummaryDto(Integer id, String name) {

    public static final AuthorSummaryDto UNKNOWN_AUTHOR = new AuthorSummaryDto(-1, "Unknown Author");
    
}
