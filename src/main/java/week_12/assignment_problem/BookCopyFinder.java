package main.java.week_12.assignment_problem;
public class BookCopyFinder {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static String find(Node head, String id) {
        int position = 1;
        int firstPos = -1;
        int copies = 0;

        Node current = head;
        while (current != null) {
            if (current.data.equals(id)) {
                if (firstPos == -1) {
                    firstPos = position;
                }
                copies++;
            }
            position++;
            current = current.next;
        }

        if (copies == 0) {
            return id + " not found";
        }
        return id + " first at position " + firstPos + ", copies: " + copies;
    }

    // Helper method to build the trolley chain for testing
    public static Node buildTrolley(String[] books) {
        if (books == null || books.length == 0) return null;
        Node head = new Node(books[0]);
        Node tail = head;
        for (int i = 1; i < books.length; i++) {
            tail.next = new Node(books[i]);
            tail = tail.next;
        }
        return head;
    }

    public static void main(String[] args) {
        String[] books = {"B12", "B07", "B30", "B07", "B45", "B07"};
        Node trolley = buildTrolley(books);

        // Sample 1
        System.out.println(find(trolley, "B07"));

        // Sample 2
        System.out.println(find(trolley, "B99"));
    }
}