package main.java.week_9.assignment_problem;
import java.util.Scanner;

abstract class Student {

    protected String name;

    Student(String name) {
        this.name = name;
    }

    abstract double getTuition();

    boolean usesBus() {
        return false;
    }

    double getTotalFee() {

        double fee = getTuition();

        if (usesBus()) {
            fee += 12000;
        }

        return fee;
    }
}

class DayScholar extends Student {

    DayScholar(String name) {
        super(name);
    }

    double getTuition() {
        return 40000;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    double getTuition() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends Student {

    ScholarshipStudent(String name) {
        super(name);
    }

    double getTuition() {
        return 20000;
    }

    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalCollected = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            Student student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new ScholarshipStudent(name);
            }

            double fee = student.getTotalFee();

            System.out.printf("%s: %.2f%n", name, fee);

            totalCollected += fee;
        }

        System.out.printf(
                "Total Collected: %.2f%n",
                totalCollected
        );

        sc.close();
    }
}
