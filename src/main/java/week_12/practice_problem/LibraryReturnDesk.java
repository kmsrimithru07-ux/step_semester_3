package main.java.week_12.practice_problem;
import java.util.Scanner;

public class LibraryReturnDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;

        String line = sc.nextLine();
        String[] commands = line.split(",");

        // Stack for returned books (size 3)
        String[] pile = new String[3];
        int top = -1;

        // Circular queue for waiting students (size 3)
        String[] queue = new String[3];
        int front = 0, rear = -1, size = 0;

        for (String rawCmd : commands) {
            String cmd = rawCmd.trim();
            if (cmd.isEmpty()) continue;

            if (cmd.startsWith("RETURN ")) {
                String book = cmd.substring(7).trim();
                if (top == 2) {
                    System.out.println(book + " rejected: pile is full");
                } else {
                    pile[++top] = book;
                    System.out.println(book + " placed on pile");
                }
            } else if (cmd.equals("SHELVE")) {
                if (top == -1) {
                    System.out.println("pile is empty");
                } else {
                    System.out.println("shelved " + pile[top--]);
                }
            } else if (cmd.startsWith("WAIT ")) {
                String student = cmd.substring(5).trim();
                if (size == 3) {
                    System.out.println(student + " rejected: line is full");
                } else {
                    rear = (rear + 1) % 3;
                    queue[rear] = student;
                    size++;
                    System.out.println(student + " joined the line");
                }
            } else if (cmd.equals("SERVE")) {
                if (size == 0) {
                    System.out.println("no one waiting");
                } else {
                    String served = queue[front];
                    front = (front + 1) % 3;
                    size--;
                    System.out.println("served " + served);
                }
            }
        }
        sc.close();
    }
}