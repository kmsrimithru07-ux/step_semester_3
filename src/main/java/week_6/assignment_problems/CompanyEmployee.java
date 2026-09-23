package main.java.week_6.assignment_problems;
class CompanyEmployee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        CompanyEmployee e1 = new CompanyEmployee("Arun", 50000);
        CompanyEmployee e2 = new CompanyEmployee("Priya", 60000);
        CompanyEmployee e3 = new CompanyEmployee("Rahul", 55000);

        System.out.println("3 Employee objects created");

        CompanyEmployee.printCompanyInfo();
    }
}
