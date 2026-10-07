package main.java.week_9.assignment_problem;
import java.util.Scanner;

abstract class Appliance {

    protected double power;

    Appliance(double power) {
        this.power = power;
    }

    double calculateUnits(double hours) {
        return (power * hours) / 1000;
    }

    boolean supportsSaver() {
        return false;
    }

    double calculateSaverUnits(double hours) {

        double units = calculateUnits(hours);

        return units * 0.75;
    }

    double calculateCost(double units) {
        return units * 8;
    }
}

class Fridge extends Appliance {

    Fridge() {
        super(150);
    }
}

class AC extends Appliance {

    AC() {
        super(1500);
    }

    boolean supportsSaver() {
        return true;
    }
}

class TV extends Appliance {

    TV() {
        super(100);
    }
}

class Washer extends Appliance {

    Washer() {
        super(500);
    }

    boolean supportsSaver() {
        return true;
    }
}

public class HomeApplianceEnergy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {
                String next = sc.nextLine().trim();

                if (next.equals("SAVER")) {
                    saver = true;
                }
            }

            Appliance appliance;

            if (type.equals("FRIDGE")) {
                appliance = new Fridge();
            } else if (type.equals("AC")) {
                appliance = new AC();
            } else if (type.equals("TV")) {
                appliance = new TV();
            } else {
                appliance = new Washer();
            }

            if (saver && !appliance.supportsSaver()) {

                System.out.println(
                        type + ": saver mode not supported"
                );

            } else {

                double units;

                if (saver) {
                    units = appliance.calculateSaverUnits(hours);
                } else {
                    units = appliance.calculateUnits(hours);
                }

                double cost = appliance.calculateCost(units);

                System.out.printf(
                        "%s: Units=%.2f Cost=%.2f%n",
                        type, units, cost
                );

                totalCost += cost;
            }
        }

        System.out.printf(
                "Total Cost: %.2f%n",
                totalCost
        );

        sc.close();
    }
}
