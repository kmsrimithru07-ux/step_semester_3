package main.java.week_8.assignment_problem;
import java.util.Scanner;

interface Room {
    double calculateBill(int units, int occupants);
}

class SingleRoom implements Room {
    public double calculateBill(int units, int occupants) {
        return units * 8;
    }
}

class SharedRoom implements Room {
    public double calculateBill(int units, int occupants) {
        return (units * 6.0) / occupants;
    }
}

class ACRoom implements Room {
    public double calculateBill(int units, int occupants) {
        return (units * 10) + 200;
    }
}

public class HostelElectricity {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            int occupants = 1;

            if (type.equals("SHARED")) {
                occupants = sc.nextInt();
            }

            Room room;

            if (type.equals("SINGLE")) {
                room = new SingleRoom();
            } else if (type.equals("SHARED")) {
                room = new SharedRoom();
            } else {
                room = new ACRoom();
            }

            double bill = room.calculateBill(units, occupants);

            System.out.printf("%s: %.2f%n", type, bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}