package main.java.week_9.practice_problem;
import java.util.Scanner;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();

    void display() {
        System.out.printf("%s (%s): %.2f%n",
                owner, getClass().getSimpleName().toUpperCase(),
                calculateArea());
    }
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            Plot plot;

            if (shape.equals("CIRCLE")) {
                double radius = sc.nextDouble();
                plot = new Circle(owner, radius);
            }
            else if (shape.equals("RECTANGLE")) {
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                plot = new Rectangle(owner, length, width);
            }
            else {
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                plot = new Triangle(owner, base, height);
            }

            plot.display();
            total += plot.calculateArea();
        }

        System.out.printf("Total Area: %.2f%n", total);

        sc.close();
    }
}
