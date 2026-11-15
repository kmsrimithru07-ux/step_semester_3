package main.java.week_11.assignment_problem;
public class TheLibraryBookShelf {

    public static void shelf(int[] books) {
        int n = books.length;

        for (int i = 1; i < n; i++) {
            int newBook = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > newBook) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = newBook;

            System.out.print("After placing " + newBook + ": ");
            printArray(books);
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        System.out.println("Sample Input:");
        shelf(new int[]{30, 10, 40, 20});

        System.out.println("\nCustom Input:");
        shelf(new int[]{25, 15, 5, 35, 20});
    }
}