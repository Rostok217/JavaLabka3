
package view;

import model.Book;
import java.util.Scanner;

public class BookView {
    private final Scanner scanner = new Scanner(System.in);

    public void showBooks(Book[] books) {
        if (books.length == 0) {
            System.out.println("Книг не знайдено.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int showMenu() {
        System.out.println("\n===== БІБЛІОТЕКА =====");
        System.out.println("1. Показати всі книги");
        System.out.println("2. Пошук за автором");
        System.out.println("3. Пошук за видавництвом");
        System.out.println("4. Книги після заданого року");
        System.out.println("5. Сортувати за видавництвом");
        System.out.println("0. Вихід");
        System.out.print("Ваш вибір: ");

        return scanner.nextInt();
    }
}
