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
     * Перевірка на вийняток при спробі створити об'єкт з неможливим роком написання
     */
    @Test
    public void exeptionOnCreateBookTest(){
        int publication_year = 3000;
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {new Book("MyBook", "Pavlo", publication_year, 1000);});
        Assertions.assertEquals("Книга має бути написана не пізніше ніж в 2026 році, ви вказали " + publication_year, e.getMessage());
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

    /**
     * Перевірка на вийняток при спробі повторно додати той самий магазин
     */
    @Test
    public void exceptionOnAddShopTest(){
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            book.addShop(Shop.COMICSMANIA);
            book.addShop((Shop.KNIGOLUB));
            book.addShop(Shop.LIBRARIUM);
            book.addShop(Shop.COMICSMANIA);
        });
        Assertions.assertEquals("Ви спробували додати магазин, що вже був доданий", e.getMessage());
    }

    /**
     * Перевірка кількості магазинів, при спробі додати кілька однакових
     */
    @Test
    public void addShopsTest(){
        try{
            book.addShop(Shop.COMICSMANIA);
            book.addShop((Shop.KNIGOLUB));
            book.addShop(Shop.LIBRARIUM);
            book.addShop(Shop.COMICSMANIA);
        } catch (IllegalArgumentException e){

        }
        Set<Shop> set = new HashSet<Shop>();
        set.add(Shop.COMICSMANIA);
        set.add(Shop.KNIGOLUB);
        set.add(Shop.LIBRARIUM);
        set.add(Shop.COMICSMANIA);
        Assertions.assertEquals(book.getShops().size(), set.size());
    }
}
