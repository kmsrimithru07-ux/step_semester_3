package main.java.week_9.assignment_problem;
import java.util.Scanner;

abstract class Cab {

    protected double rate;

    Cab(double rate) {
        this.rate = rate;
    }

    double calculateFare(double km) {

        double fare = km * rate;

        if (fare < 100) {
            fare = 100;
        }

        return fare;
    }

    boolean nightServiceAvailable() {
        return false;
    }

    double calculateNightFare(double km) {

        double fare = calculateFare(km);

        return fare * 1.20;
    }
}

class Mini extends Cab {

    Mini() {
        super(10);
    }
}

class Sedan extends Cab {

    Sedan() {
        super(14);
    }

    boolean nightServiceAvailable() {
        return true;
    }
}

class SUV extends Cab {

    SUV() {
        super(18);
    }

    boolean nightServiceAvailable() {
        return true;
    }
}

public class CityCabFare {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI")) {
                cab = new Mini();
            } else if (type.equals("SEDAN")) {
                cab = new Sedan();
            } else {
                cab = new SUV();
            }

            if (time.equals("NIGHT")
                    && !cab.nightServiceAvailable()) {

                System.out.println(
                        type + ": night service not available"
                );

            } else {

                double fare;

                if (time.equals("NIGHT")) {
                    fare = cab.calculateNightFare(km);
                } else {
                    fare = cab.calculateFare(km);
                }

                System.out.printf(
                        "%s: %.2f%n",
                        type, fare
                );

                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
