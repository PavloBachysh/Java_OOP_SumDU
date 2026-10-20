package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Assertions.assertThrows(IllegalArgumentException.class, () -> {book.setPrice(-100);});
    }

    /**
     * Перевірка на вийняток при спробі створити об'єкт з неможливим роком написання
     */
    @Test
    public void exeptionOnCreateBookTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Book("MyBook", "Pavlo", 3000, 1000);});
    }

    /**
     * Перевірка на вийняток при спробі задати автора одним символом
     */
    @Test
    public void exeptionOnSetAuthorTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {book.setAuthor("I");});
    }

    /**
     * Перевірка на відсутність вийнятків при встановленні назви книги
     */
    @Test
    public void exeptionNotThrowOnSetTitleTest(){
        Assertions.assertDoesNotThrow(() -> {book.setTitle("Book");});
    }
}
