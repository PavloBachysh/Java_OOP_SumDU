package org.example;

import java.util.Date;

/**
 * Клас <b>Book</b>
 * Основний клас для виконання лабораторної роботи.
 * Має геттери, сеттери, конструктор, перевірки і перевантажені методи <b>toString()</b>, <b>equals()</b>
 */
public class Book {
    /**Назва книги*/
    private String title;
    /**Автор книги*/
    private String author;
    /**Рік написання*/
    private int publication_year;
    /**Ціна книги*/
    private float price;

    /**
     * Конструктор класу
     * @param title - Назва книги (Має бути хоча б один символ не пробіл)
     * @param author - Автор книги (Від 3 до 60 символів)
     * @param publication_year - Рік написання (не більше ніж 2026 рік)
     * @param price - Ціна книги (Не від'ємна)
     * @throws IllegalArgumentException - Якщо заданий аргумент не відповідає умовам
     */
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

    /**
     * Перевантажений метод toString()
     * @return опис книги
     */
    public String toString(){
        return "Назва книги: '" + title +
                "' і вона була написана автором " + author +
                " в " + publication_year +
                " році, її ціна " + price + "гривень";
    }

    /**
     * Перевантажений метод toString()
     * @param b - Книга, з якою порівнюєтсья поточна
     * @return true - книги однакові, false - книги різні
     */
    public boolean equals(Book b){
        return title.equals(b.title) &&
                author.equals(b.author) &&
                publication_year == b.publication_year &&
                Float.compare(price, b.price)==0;
    }
}
