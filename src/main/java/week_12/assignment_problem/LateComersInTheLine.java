package main.java.week_12.assignment_problem;
public class LateComersInTheLine {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    public static Node addLast(Node head, String name) {
        Node newNode = new Node(name);
        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static void printLine(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample 1: Starting line Asha -> Ravi
        Node head1 = null;
        head1 = addLast(head1, "Asha");
        head1 = addLast(head1, "Ravi");

        head1 = addFirst(head1, "Neha");
        head1 = addLast(head1, "Kiran");
        head1 = addFirst(head1, "Mohan");
        printLine(head1);

        // Sample 2: Empty starting line
        Node head2 = null;
        head2 = addLast(head2, "Pooja");
        head2 = addFirst(head2, "Arun");
        printLine(head2);
    }
}