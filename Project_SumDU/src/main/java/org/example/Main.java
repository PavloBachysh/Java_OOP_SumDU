package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Book book = new Book("Me", "Pavlo Bachysh", 2026);
        System.out.println(book.getTitle());
    }
}
