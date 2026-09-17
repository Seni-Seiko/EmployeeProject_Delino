import version4.BasePlusCommissionEmployee;
import version4.CommissionEmployee;
import version4.Employee;
import version4.EmployeeRoster;
import version4.HourlyEmployee;
import version4.MyDate;
import version4.Name;
import version4.PieceWorkerEmployee;

public class Main4 {

    public static void main(String[] args) {

        EmployeeRoster roster = new EmployeeRoster(6);

        HourlyEmployee hourly1 = new HourlyEmployee(
                101,
                new Name("Alice", "Maria", "Smith"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                45.0f,
                200.0
        );

        PieceWorkerEmployee piece = new PieceWorkerEmployee(
                201,
                new Name("Bob", "Carlos", "Jones", "Jr."),
                new MyDate(5, 4, 1998),
                new MyDate(15, 1, 2023),
                90,
                45.0
        );

        CommissionEmployee commission = new CommissionEmployee(
                301,
                new Name("Maria", "Lopez", "Reyes"),
                new MyDate(20, 9, 2001),
                new MyDate(10, 2, 2024),
                100000.0
        );

        BasePlusCommissionEmployee basePlus =
                new BasePlusCommissionEmployee(
                        401,
                        new Name("Kevin", "Samuel", "Tan"),
                        new MyDate(12, 5, 1999),
                        new MyDate(8, 7, 2022),
                        60000.0,
                        15000.0
                );

        HourlyEmployee hourly2 = new HourlyEmployee(
                102,
                new Name("David", "Andrew", "White"),
                new MyDate(10, 3, 2001),
                new MyDate(15, 7, 2023),
                40.0f,
                200.0
        );

        CommissionEmployee extraEmployee = new CommissionEmployee(
                501,
                new Name("Extra", "Test", "Employee"),
                new MyDate(1, 1, 2000),
                new MyDate(1, 1, 2025),
                50000.0
        );

        System.out.println("======================================================================");
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println("======================================================================");

        System.out.printf(
                "Added: %s (Hourly) -> %s%n",
                hourly1.getEmpName(),
                roster.addEmployee(hourly1) ? "Success" : "Failed"
        );

        System.out.printf(
                "Added: %s (Piece Worker) -> %s%n",
                piece.getEmpName(),
                roster.addEmployee(piece) ? "Success" : "Failed"
        );

        System.out.printf(
                "Added: %s (Commission) -> %s%n",
                commission.getEmpName(),
                roster.addEmployee(commission) ? "Success" : "Failed"
        );

        System.out.printf(
                "Added: %s (Base Plus Commission) -> %s%n",
                basePlus.getEmpName(),
                roster.addEmployee(basePlus) ? "Success" : "Failed"
        );

        System.out.printf(
                "Added: %s (Hourly) -> %s%n",
                hourly2.getEmpName(),
                roster.addEmployee(hourly2) ? "Success" : "Failed"
        );

        Employee sixthEmployee = new HourlyEmployee(
                601,
                new Name("Sixth", "Test", "Employee"),
                new MyDate(1, 1, 2000),
                new MyDate(1, 1, 2025),
                20.0f,
                100.0
        );

        System.out.printf(
                "Added: %s -> %s%n",
                sixthEmployee.getEmpName(),
                roster.addEmployee(sixthEmployee) ? "Success" : "Failed"
        );

        System.out.printf(
                "Attempted extra employee -> %s%n",
                roster.addEmployee(extraEmployee) ? "Success" : "Failed (Roster Full)"
        );

        System.out.println();
        System.out.println("--- ROSTER COMPOSITION COUNTS ---");

        System.out.println(
                "Total Employees: "
                        + roster.getCount()
                        + " / "
                        + roster.getMax()
        );

        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("CATEGORICAL EMPLOYEE DISPLAY");
        System.out.println("======================================================================");

        System.out.println("\n--- Hourly Employees ---");
        roster.displayHE();

        System.out.println("\n--- Piece Worker Employees ---");
        roster.displayPWE();

        System.out.println("\n--- Commission Employees ---");
        roster.displayCE();

        System.out.println("\n--- Base Plus Commission Employees ---");
        roster.displayBPCE();

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("ROSTER PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");

        roster.displayPayroll(9);

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println("======================================================================");

        System.out.println(
                "Removing Employee ID 201 ("
                        + piece.getEmpName()
                        + ")..."
        );

        Employee removed = roster.removeEmployee(201);

        if (removed != null) {
            System.out.println("Successfully removed.");
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("Current Employee Count: " + roster.getCount());

        System.out.println();
        System.out.println("Remaining Employees in Roster:");

        roster.displayAllEmployees();

        System.out.println();
        System.out.println("Searching for Employee ID 301:");

        Employee found = roster.searchEmployee(301);

        if (found != null) {
            System.out.println(
                    "Found: "
                            + found.getEmpName()
                            + " ("
                            + found.getClass().getSimpleName()
                            + ")"
            );
        } else {
            System.out.println("Employee not found.");
        }
    }
}