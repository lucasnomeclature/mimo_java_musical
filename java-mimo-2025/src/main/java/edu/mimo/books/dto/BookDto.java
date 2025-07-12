package edu.mimo.books.dto;

public class BookDto {
    private Integer id;
    private String isbn;
    private String title;
    private AuthorSummaryDto author;
    private String country;
    private String originalLanguage;
    private Integer year;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getOriginalLanguage() {
        return originalLanguage;
    }
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public AuthorSummaryDto getAuthor() {
        return author;
    }
    public void setAuthor(AuthorSummaryDto author) {
        this.author = author;
    }
} 