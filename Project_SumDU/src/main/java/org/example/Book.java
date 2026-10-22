package org.example;

import java.util.ArrayList;
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
    /**Магазини, в яких є ця книга*/
    private ArrayList<Shop> shops;
    /**Кількість створених об'єктів*/
    private static int counter = 0;

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
            throw new IllegalArgumentException("Назва книги має містити хоча б 1 символ відмінний від пробілу");
        } else {
            this.title = title;
        }
        if (author.length() < 3 || author.length() > 60){
            throw new IllegalArgumentException("Автор має бути від 3 до 60 літер, ви вказали " + author.length());
        } else {
            this.author = author;
        }
        if (publication_year > 2026){
            throw new IllegalArgumentException("Книга має бути написана не пізніше ніж в 2026 році, ви вказали " + publication_year);
        } else {
            this.publication_year = publication_year;
        }
        if (price < 0){
            throw new IllegalArgumentException("Ціна має бути невід'ємною, ви вказали " + price);
        } else {
            this.price = price;
        }
        shops = new ArrayList<Shop>();
        counter++;

    }

    /**
     * Конструктор копіювання
     * @param book
     */
    public Book(Book book){
        this.title = book.title;
        this.author = book.author;
        this.publication_year = book.publication_year;
        this.price = book.price;
        shops = new ArrayList<Shop>();
        shops.addAll(book.shops);
        counter++;
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
    public ArrayList<Shop> getShops() {return new ArrayList<Shop>(shops);}
    public static int getCounter() {return counter;}

    public void setTitle(String title){
        if (title.trim().length() == 0){
            throw new IllegalArgumentException("Назва книги має містити хоча б 1 символ відмінний від пробілу");
        } else {
            this.title = title;
        }
    }
    public void setAuthor(String author){
        if (author.length() < 3 || author.length() > 60){
            throw new IllegalArgumentException("Автор має бути від 3 до 60 літер, ви вказали " + author.length());
        } else {
            this.author = author;
        }
    }
    public void setPublicationYear(int publication_year){
        if (publication_year > 2026){
            throw new IllegalArgumentException("Книга має бути написана не пізніше ніж в 2026 році, ви вказали " + publication_year);
        } else {
            this.publication_year = publication_year;
        }
    }
    public void setPrice(float price){
        if (price < 0){
            throw new IllegalArgumentException("Ціна має бути невід'ємною, ви вказали " + price);
        } else {
            this.price = price;
        }
    }
    public void setShops(ArrayList<Shop> shops){
        this.shops.clear();
        this.shops.addAll(shops);
    }

    /**
     * Додавання нового магазину
     * @param shop новий магазин
     */
    public void addShop(Shop shop){
        if (shops.contains(shop)){
            throw new IllegalArgumentException("Ви спробували додати магазин, що вже був доданий");
        }else{
            shops.add(shop);
        }
    }

    /**
     * Перевантажений метод toString()
     * @return опис книги
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Назва книги: '" + title +
                "' і вона була написана автором " + author +
                " в " + publication_year +
                " році, її ціна " + price + "гривень\n" +
                "   її можна знайти в такох магазинах: ");
        for (Shop shop : shops){
            sb.append(shop.toString() + ", ");
        }
        sb.delete(sb.length()-2, sb.length()-1);
        return sb.toString();
    }

    /**
     * метод equals()
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
