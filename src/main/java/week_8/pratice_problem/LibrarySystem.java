package main.java.week_8.pratice_problem;
import java.util.*;
import java.time.LocalDate;

abstract class LibraryItem {

    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract LocalDate getDueDate();
}

class Book extends LibraryItem {

    Book(String title) {
        super(title);
    }

    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(14);
    }
}

class DVD extends LibraryItem {

    DVD(String title) {
        super(title);
    }

    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(7);
    }
}

class Magazine extends LibraryItem {

    Magazine(String title) {
        super(title);
    }

    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(3);
    }
}

public class LibrarySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            int space = line.indexOf(" ");

            String type = line.substring(0, space);
            String title = line.substring(space + 1);

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            System.out.println(
                    item.title + " - Due Date: " + item.getDueDate()
            );
        }

        sc.close();
    }
}