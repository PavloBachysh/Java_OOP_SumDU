package org.example;

import org.junit.jupiter.api.AssertionFailureBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Клас тестів
 */
public class BookTest {
    Book book;

    /**
     * Метод, що викликається перед кожнім тестом для створення\повернення об'єкту до початкового стану
     */
    @BeforeEach
    public void prepareTest(){
        book = new Book("MyBook", "Pavlo", 2025, 1000);
    }

    /**
     * Перевірка на вийняток при спробі встановити від'ємну ціну
     */
    @Test
    public void exeptionOnSetPriceTest(){
        float price = -100;
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {book.setPrice(price);});
        Assertions.assertEquals("Ціна має бути невід'ємною, ви вказали " + price, e.getMessage());
    }

    /**
     * Перевірка на вийняток при спробі створити книгу з неможливим роком написання
     */
    @Test
    public void exeptionOnCreateBookTest(){
        int publication_year = 3000;
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Book("MyBook", "Pavlo", publication_year, 1000);});
        Assertions.assertEquals("Книга має бути написана не пізніше ніж в 2026 році, ви вказали " + publication_year, e.getMessage());
    }

    /**
     * Перевірка на вийняток при спробі створити електронну книгу з неправильним посиланням
     */
    @Test
    public void exeptionOnCreateEBookTest(){
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new EBook(book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getPrice(), "something");
        });
        Assertions.assertEquals("Це посилання занадто коротке (менше 6 символів) або не містітить '.'", e.getMessage());
    }

    /**
     * Перевірка на вийняток при спробі створити паперову книгу з від'ємною кількістю сторінок
     */
    @Test
    public void exeptionOnCreatePaperBookTest(){
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new PaperBook(book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getPrice(), -3);
        });
        Assertions.assertEquals("Кількість сторінок має бути невід'ємною", e.getMessage());
    }


    /**
     * Перевірка на вийняток при спробі задати автора одним символом
     */
    @Test
    public void exeptionOnSetAuthorTest(){
        String author = "I";
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {book.setAuthor(author);});
        Assertions.assertEquals("Автор має бути від 3 до 60 літер, ви вказали " + author.length(), e.getMessage());
    }

    /**
     * Перевірка на відсутність вийнятків при встановленні назви книги
     */
    @Test
    public void exeptionNotThrowOnSetTitleTest(){
        Assertions.assertDoesNotThrow(() -> {book.setTitle("Book");});
    }

}
