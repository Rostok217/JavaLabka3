
package controller;

import model.Book;
import view.BookView;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class BookController {
    private final BookView view;
    private final Book[] books;
    private final Random random = new Random();

    public BookController(BookView view) {
        this.view = view;
        this.books = initializeBooks();
    }

    private Book[] initializeBooks() {
        return new Book[]{
                new Book("Кобзар", "Тарас Шевченко", "Фоліо", 2020, 320, 250),
                new Book("Лісова пісня", "Леся Українка", "А-БА-БА-ГА-ЛА-МА-ГА", 2018, 180, 190),
                new Book("Захар Беркут", "Іван Франко", "Фоліо", 2022, 240, 220),
                new Book("Тигролови", "Іван Багряний", "КСД", 2019, 280, 270),
                new Book("Місто", "Валер'ян Підмогильний", "Фоліо", 2017, 350, 300),
                new Book("Тіні забутих предків", "Михайло Коцюбинський", "КСД", 2021, 160, 180),
                new Book("Маруся Чурай", "Ліна Костенко", "А-БА-БА-ГА-ЛА-МА-ГА", 2023, 220, 290),
                new Book("Чорна рада", "Пантелеймон Куліш", "Ранок", 2016, 300, 210),
                new Book("Кайдашева сім'я", "Іван Нечуй-Левицький", "Ранок", 2024, 200, 230),
                new Book("Intermezzo", "Михайло Коцюбинський", "КСД", 2022, 120, 150),
                new Book("Енеїда", "Іван Котляревський", "Фоліо", 2021, 260, 240),
                new Book("Собор", "Олесь Гончар", "Ранок", 2019, 400, 320)
        };
    }

    public void start() {
        view.showMessage("ПОЧАТКОВИЙ СПИСОК КНИГ:");
        view.showBooks(books);

        boolean running = true;

        while (running) {
            int choice = view.showMenu();

            switch (choice) {
                case 1 -> view.showBooks(books);
                case 2 -> searchByAuthor();
                case 3 -> searchByPublisher();
                case 4 -> searchByYear();
                case 5 -> sortByPublisher();
                case 0 -> {
                    view.showMessage("Програму завершено.");
                    running = false;
                }
                default -> view.showMessage("Неправильний пункт меню!");
            }
        }
    }

    private void searchByAuthor() {
        String[] authors = {
                "Тарас Шевченко",
                "Леся Українка",
                "Іван Франко",
                "Михайло Коцюбинський"
        };

        String author = authors[random.nextInt(authors.length)];

        view.showMessage("\nПошук книг автора: " + author);

        Book[] result = Arrays.stream(books)
                .filter(book -> book.getAuthor().equals(author))
                .toArray(Book[]::new);

        view.showBooks(result);
    }


    private void searchByPublisher() {
        String[] publishers = {
                "Фоліо",
                "КСД",
                "Ранок",
                "А-БА-БА-ГА-ЛА-МА-ГА"
        };

        String publisher = publishers[random.nextInt(publishers.length)];

        view.showMessage("\nПошук книг видавництва: " + publisher);

        Book[] result = Arrays.stream(books)
                .filter(book -> book.getPublisher().equals(publisher))
                .toArray(Book[]::new);

        view.showBooks(result);
    }


    private void searchByYear() {
        int[] years = {2015, 2018, 2020, 2022};

        int year = years[random.nextInt(years.length)];

        view.showMessage("\nКниги, видані пізніше " + year + " року:");

        Book[] result = Arrays.stream(books)
                .filter(book -> book.getYear() > year)
                .toArray(Book[]::new);

        view.showBooks(result);
    }

    private void sortByPublisher() {
        Book[] sortedBooks = books.clone();

        Arrays.sort(sortedBooks,
                Comparator.comparing(Book::getPublisher));

        view.showMessage("\nКниги, відсортовані за видавництвом:");
        view.showBooks(sortedBooks);
    }
}
