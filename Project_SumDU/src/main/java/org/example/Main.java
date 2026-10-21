package org.example;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Головнйи клас програми
 */
public class Main {
    /**
     * Драйвер програми
     */
    static void main() {
        ArrayList<Book> books = new ArrayList<Book>();
        Scanner scanner = new Scanner(System.in);
        int command;
        while (true) {
            printMenu();
            try {
                command = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введені некоректні дані, введіть одне з запропонованих чисел");
                scanner.next();
                continue;
            }
            scanner.nextLine();
            switch (command) {
                case 1:
                    Book newBook = createBook(scanner);
                    if (newBook != null) {
                        books.add(newBook);
                        System.out.println("Нову книгу додано!");
                    } else {
                        System.out.println("Неправильно введено дані для нової книги");
                    }
                    break;
                case 2:
                    if (printBooks(books) == false) {
                        System.out.println("Книг немає");
                    }
                    break;
                case 3:
                    System.out.println("Завершення роботи");
                    return;
                default:
                    System.out.println("Даної команди не існує");
                    break;
            }
        }

    }

    /**
     * Вивід тексту меню винесений окремим методом
     */
    private static void printMenu() {
        System.out.println(
                "Виберіть команду: \n" +
                        "1 - Додати нову книгу\n" +
                        "2 - Вивести інформацію про всі книги\n" +
                        "3 - Завершити роботу"
        );
    }

    /**
     * Метод створення нового обє'кту книги <b>Book</b>
     *
     * @param scanner - сканер (для введення)
     * @return <b>Book</b>
     */
    private static Book createBook(Scanner scanner) {
        String title;
        String author;
        int publication_year;
        float price;
        System.out.println("Введіть назву: ");
        title = scanner.nextLine();
        System.out.println("Введіть автора: ");
        author = scanner.nextLine();
        System.out.println("Введіть рік написання: ");
        try {
            publication_year = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            return null;
        }
        System.out.println("Введіть ціну: ");
        try {
            price = scanner.nextFloat();
        } catch (InputMismatchException e) {
            scanner.next();
            return null;
        }
        try {
            Book newBook = new Book(title, author, publication_year, price);
            addNewShop(newBook, scanner);
            return newBook;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static void addNewShop(Book book, Scanner scanner) {
        int command;
        while (true) {
            System.out.println("Чи бажаєте ви додати магазин, в якому продається ця книга?\n1 - Так\n0 - Ні");
            try {
                command = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введені некоректні дані, введіть одне з запропонованих чисел");
                scanner.next();
                continue;
            }
            scanner.nextLine();
            if (command == 1) {
                System.out.println("1 - Книголюб\n2 - Книгарня.Є\n3 - Лібраріум\n4 - Comics Mania\n0 - Завершити");
                try {
                    command = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Введені некоректні дані, введіть одне з запропонованих чисел");
                    scanner.next();
                    continue;
                }
                scanner.nextLine();
                try{
                    switch (command) {
                        case 1:
                            book.addShop(Shop.KNIGOLUB);
                            break;
                        case 2:
                            book.addShop(Shop.KNIGARNYAE);
                            break;
                        case 3:
                            book.addShop(Shop.LIBRARIUM);
                            break;
                        case 4:
                            book.addShop(Shop.COMICSMANIA);
                            break;
                        case 0:
                            break;
                    }
                } catch(IllegalArgumentException e){
                    System.out.println("Даний магазин вже було додано, спробуйте інший");
                }

            } else {
                if (command == 0) {
                    return;
                }
                System.out.println("Даної команди не існує");
            }
        }
    }

    /**
     * Метод виведення всіх книг списку
     * @param books - список книг (ArrayList<Book>)
     * @return true - список не пустий, false - пустий список
     */
    private static boolean printBooks(ArrayList<Book> books){
        if (!books.isEmpty()){
            int i = 0;
            System.out.println("Загальна кількість книг: " + Book.getCounter() + ". " + "Всі книги:");
            for (Book book : books){
                i++;
                System.out.println(i + ": " + book.toString());
            }
            System.out.println();
            return true;
        }
        return false;
    }

}
