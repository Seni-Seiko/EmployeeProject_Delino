import version6.*;

public class Main6 {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("1. TESTING ENCAPSULATION & DEFENSIVE COPYING");
        System.out.println("======================================================================");
        MyDate originalBirthDate = new MyDate(15, 12, 1995);
        HourlyEmployee employee = new HourlyEmployee(101, new Name("Alice", "Maria", "Smith"), originalBirthDate, new MyDate(1, 6, 2022), 45, 200);
        System.out.println("Original Birth Month: " + employee.getBirthDate().getMonth() + " (Dec)");
        System.out.println("Attempting external tampering: emp.getBirthDate().setMonth(9)...");
        MyDate externalDate = employee.getBirthDate();
        externalDate.setMonth(9);
        System.out.println("Employee's Actual Birth Date after tampering attempt: " + employee.getBirthDate());
        if (employee.getBirthDate().getMonth() == 12) {
            System.out.println("Result: SUCCESS (Internal state protected via defensive copying)");
        }
        System.out.println();
        System.out.println("======================================================================");
        System.out.println("2. TESTING EXCEPTION HANDLING & INPUT VALIDATION");
        System.out.println("======================================================================");
        try {
            System.out.println("Attempting to create HourlyEmployee with rate: -150.00...");
            new HourlyEmployee(102, new Name("Test", "Employee"), new MyDate(1, 1, 2000), new MyDate(1, 1, 2022), 40, -150);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: [IllegalArgumentException] " + e.getMessage());
        }
        try {
            System.out.println();
            System.out.println("Attempting to assign invalid calendar date: 31 Feb 2026...");
            new MyDate(31, 2, 2026);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: [IllegalArgumentException] " + e.getMessage());
        }
        System.out.println();
        System.out.println("======================================================================");
        System.out.println("3. POLYMORPHIC PAYROLL EXECUTION (Target Month: Sep)");
        System.out.println("[Dynamic Dispatch via Abstract Contract computeSalary()]");
        System.out.println("======================================================================");
        EmployeeRoster roster = new EmployeeRoster();
        roster.addEmployee(new HourlyEmployee(101, new Name("Alice", "Maria", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200));
        roster.addEmployee(new PieceWorkerEmployee(201, new Name("Bob", "Carlos", "Jones", "Jr."), new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 90, 45));
        roster.addEmployee(new CommissionEmployee(301, new Name("Maria", "Lopez", "Reyes"), new MyDate(20, 9, 2001), new MyDate(10, 2, 2023), 100000));
        roster.addEmployee(new BasePlusCommissionEmployee(401, new Name("Kevin", "Samuel", "Tan"), new MyDate(12, 5, 1999), new MyDate(8, 7, 2022), 60000, 15000));
        roster.displayPayroll(9);
        System.out.println();
        System.out.println("======================================================================");
        System.out.println("4. ROSTER SUMMARY");
        System.out.println("======================================================================");
        System.out.println("Total Employees: " + roster.countEmployees());
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Workers: " + roster.countPWE());
        System.out.println("Commission Employees: " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());
    }
}