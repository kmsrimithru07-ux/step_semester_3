package main.java.week_8.pratice_problem;
import java.util.*;

interface Transport {
    double calculateFare(double distance);
}

class Bus implements Transport {

    public double calculateFare(double distance) {

        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }
}

class Train implements Transport {

    public double calculateFare(double distance) {
        return 3 + (0.15 * distance);
    }
}

class Metro implements Transport {

    double peakHourFactor;

    Metro(double peakHourFactor) {
        this.peakHourFactor = peakHourFactor;
    }

    public double calculateFare(double distance) {

        return (1.50 + (0.20 * distance))
                * peakHourFactor;
    }
}

public class TransportSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            Transport transport;

            if (type.equals("BUS")) {

                transport = new Bus();

            } else if (type.equals("TRAIN")) {

                transport = new Train();

            } else {

                double peakHourFactor = sc.nextDouble();

                transport = new Metro(peakHourFactor);
            }

            double fare = transport.calculateFare(distance);

            System.out.printf("%s %.2f%n", type, fare);

            total += fare;
        }

        System.out.printf("Total %.2f%n", total);

        sc.close();
    }
}
