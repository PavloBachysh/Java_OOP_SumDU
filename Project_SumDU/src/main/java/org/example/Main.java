package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Book[] books = new Book[5];
        Book book1 = new Book("Me", "Pavlo Bachysh", 2026, 10);
        books[0] = book1;
        books[1] = new Book("Me", "Pavlo Bachysh", 2026, 10);
        books[2] = new Book("Енеїда", "Котляревський", 1798, 12.5f);
        books[3] = new Book("Кобзар", "Т.Г. Шевченко", 1859, 5);
        books[4] = new Book("Не знаю", "Невідомо", 1991, 200);
        for (int i = 0; i < books.length; i++){
            System.out.println("Книга номер " + (i+1) + "\n" + books[i].toString() + "\n");
        }

        System.out.print("Перша і друга книга - ");
        if (books[0].equals(books[1])){
            System.out.println("Однакові");
        } else{
            System.out.println("Різні");
        }

        System.out.print("Друга і третя книга - ");
        if (books[1].equals(books[2])){
            System.out.println("Однакові");
        } else{
            System.out.println("Різні");
        }
    }
}
