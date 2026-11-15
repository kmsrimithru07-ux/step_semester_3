package main.java.week_11.practice_problem;
import java.util.*;

public class LibraryCatalogLookup {
    static class Book {
        String isbn;
        String title;

        Book(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }

    public static String findBook(List<Book> catalog, String targetIsbn) {
        int left = 0;
        int right = catalog.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = catalog.get(mid).isbn.compareTo(targetIsbn);

            if (cmp == 0) {
                return catalog.get(mid).title;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return "Not Found";
    }
}