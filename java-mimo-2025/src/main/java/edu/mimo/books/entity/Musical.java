package edu.mimo.books.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "musical")
public class Musical implements Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String originalLanguage;


    //private int price;
    //@Column(name = "pub_year")
    
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Musical() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String label() {
        return getTitle();
    }

    @Override
    public String description() {
        return getTitle() + " Publié en " + getYear();
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String code() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'code'");
    }

    @Override
    public int price() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'price'");
    }

    
}