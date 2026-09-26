package main.java.week_8.pratice_problem;
import java.util.*;

interface Delivery {
    double calculateFee(double weight, double distance);
}

class StandardDelivery implements Delivery {

    public double calculateFee(double weight, double distance) {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery implements Delivery {

    public double calculateFee(double weight, double distance) {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery implements Delivery {

    public double calculateFee(double weight, double distance) {

        double customsFee = 10;

        return 25 + (2.00 * weight)
                + (0.50 * distance)
                + customsFee;
    }
}

public class DeliverySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            Delivery delivery;

            if (type.equals("STANDARD")) {
                delivery = new StandardDelivery();
            } else if (type.equals("EXPRESS")) {
                delivery = new ExpressDelivery();
            } else {
                delivery = new InternationalDelivery();
            }

            double fee = delivery.calculateFee(weight, distance);

            System.out.printf("%s %.2f%n", type, fee);
        }

        sc.close();
    }
}