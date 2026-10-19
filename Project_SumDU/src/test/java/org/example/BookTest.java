package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {
    Book book;

    @BeforeEach
    public void prepareTest(){
        book = new Book("MyBook", "Pavlo", 2025, 1000);
    }

    @Test
    public void exeptionOnSetPriceTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {book.setPrice(-100);});
    }

    @Test
    public void exeptionOnCreateBookTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Book("MyBook", "Pavlo", 3000, 1000);});
    }

    @Test
    public void exeptionOnSetAuthorTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {book.setAuthor("I");});
    }

    @Test
    public void exeptionNotThrowOnSetTitleTest(){
        Assertions.assertDoesNotThrow(() -> {book.setTitle("Book");});
    }
}
