package main.java.week_12.assignment_problem;
public class CancelABooking {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }

        // Case 1: The booking to cancel is at the head
        if (head.data.equals(booking)) {
            return head.next;
        }

        // Case 2: Search for the node just before the matching booking
        Node current = head;
        while (current.next != null && !current.next.data.equals(booking)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println(booking + " not found");
        }

        return head;
    }

    // Helper methods to build and print the booking chain for testing
    public static Node buildBookings(String[] bookings) {
        if (bookings == null || bookings.length == 0) return null;
        Node head = new Node(bookings[0]);
        Node tail = head;
        for (int i = 1; i < bookings.length; i++) {
            tail.next = new Node(bookings[i]);
            tail = tail.next;
        }
        return head;
    }

    public static void printBookings(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample 1
        Node list1 = buildBookings(new String[]{"104", "101", "107", "101"});
        list1 = removeFirst(list1, "101");
        printBookings(list1);

        // Sample 2
        Node list2 = buildBookings(new String[]{"104", "101", "107"});
        list2 = removeFirst(list2, "104");
        printBookings(list2);

        // Sample 3
        Node list3 = buildBookings(new String[]{"104", "101"});
        list3 = removeFirst(list3, "200");
        printBookings(list3);
    }
}