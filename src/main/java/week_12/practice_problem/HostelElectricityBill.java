package main.java.week_12.practice_problem;
import java.util.Scanner;

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        int roomsBilled = 0;
        int totalBlockBill = 0;

        for (int i = 0; i < n; i++) {
            String roomNo = sc.next();
            int units = sc.nextInt();

            if (units < 0) {
                System.out.println(roomNo + ": invalid reading");
            } else {
                int bill = 50; // Fixed meter charge
                if (units <= 100) {
                    bill += units * 3;
                } else if (units <= 200) {
                    bill += (100 * 3) + ((units - 100) * 5);
                } else {
                    bill += (100 * 3) + (100 * 5) + ((units - 200) * 8);
                }

                roomsBilled++;
                totalBlockBill += bill;
                System.out.println(roomNo + ": " + units + " units, bill " + bill);
            }
        }

        System.out.println("Rooms billed " + roomsBilled + ", total " + totalBlockBill);
        sc.close();
    }
}