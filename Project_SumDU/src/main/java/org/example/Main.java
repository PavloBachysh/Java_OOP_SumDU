package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Book book1 = new Book("Me", "Pavlo Bachysh", 2026);
        Book book2 = new Book("Me", "Pavlo Bachysh", 2026);
        System.out.println(book1.toString());
        if (book1.equals(book2)){
            System.out.println("Однакові");
        } else{
            System.out.println("Різні");
        }
    }
}
