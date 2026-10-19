package org.example;

import java.util.Date;

public class Book {
    private String title;
    private String author;
    private int publication_year;
    private float price;

    public Book(String title, String author, int publication_year, float price){
        if (title.trim().length() == 0){
            throw new IllegalArgumentException();
        } else {
            this.title = title;
        }
        if (author.length() < 3 || author.length() > 60){
            throw new IllegalArgumentException();
        } else {
            this.author = author;
        }
        if (publication_year > 2026){
            throw new IllegalArgumentException();
        } else {
            this.publication_year = publication_year;
        }
        if (price < 0){
            throw new IllegalArgumentException();
        } else {
            this.price = price;
        }

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
    public float getPrice() {return price;}

    public String setTitle(String title){
        if (title.trim().length() == 0){
            throw new IllegalArgumentException();
        } else {
            this.title = title;
        }
        return title;
    }
    public String setAuthor(String author){
        if (author.length() < 3 || author.length() > 60){
            throw new IllegalArgumentException();
        } else {
            this.author = author;
        }
        return author;
    }
    public int setPublicationYear(int publication_year){
        if (publication_year > 2026){
            throw new IllegalArgumentException();
        } else {
            this.publication_year = publication_year;
        }
        return publication_year;
    }
    public float setPrice(float price){
        if (price < 0){
            throw new IllegalArgumentException();
        } else {
            this.price = price;
        }
        return price;
    }

    public String toString(){
        return "Book has title: '" + title +
                "' and was written by " + author +
                " published in " + publication_year +
                " price is " + price + "$";
    }

    public boolean equals(Book b){
        return title.equals(b.title) &&
                author.equals(b.author) &&
                publication_year == b.publication_year &&
                Float.compare(price, b.price)==0;
    }
}
