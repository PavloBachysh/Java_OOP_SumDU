package org.example;

public class Book {
    private String title;
    private String author;
    private int publication_year;

    public Book(String title, String author, int publication_year){
        this.title = title;
        this.author = author;
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

    public String toString(){
        return "Book has title: '" + title +
                "' and was written by " + author +
                " published in " + publication_year;
    }

    public boolean equals(Book b){
        return title.equals(b.title) &&
                author.equals(b.author) &&
                publication_year == b.publication_year;
    }
}
