package org.example;

public class Book {
    String title;
    String author;
    int publication_year;

    public Book(String title, String author, int publication_year){
        this.title = title;
        this.author = author;
        this.publication_year = publication_year;
    }

    public Book(String title, int publication_year){
        this.title = title;
        this.author = "Anonim";
        this.publication_year = publication_year;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getPublicationYear(){
        return publication_year;
    }

    public String setTitle(String title){
        this.title = title;
        return title;
    }
    public String setAuthor(String author){
        this.author = author;
        return author;
    }
    public int setPublicationYear(int publication_year){
        this.publication_year = publication_year;
        return publication_year;
    }
}
