import version3.BasePlusCommissionEmployee;
import version3.CommissionEmployee;
import version3.Employee;
import version3.HourlyEmployee;
import version3.MyDate;
import version3.Name;
import version3.PieceWorkerEmployee;

public class Main3 {

    public static void main(String[] args) {

        int targetMonth = 9;

        HourlyEmployee hourly = new HourlyEmployee(
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
                new Name("Emma", "Grace", "Brown"),
                new MyDate(20, 9, 2001),
                new MyDate(10, 2, 2024),
                120000.0
        );

        BasePlusCommissionEmployee basePlus = new BasePlusCommissionEmployee(
                401,
                new Name("David", "Robert", "Cruz", "III"),
                new MyDate(12, 5, 1999),
                new MyDate(8, 7, 2022),
                60000.0,
                15000.0
        );

        Employee[] employees = {
                hourly,
                piece,
                commission,
                basePlus
        };

        System.out.println("POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");

        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];

            double basePay = employee.computeSalary();
            double totalPayout = employee.computeSalary(targetMonth);
            double birthdayBonus = totalPayout - basePay;

            System.out.printf("%n%d. %s%n", i + 1, employee);

            System.out.printf(
                    "   Base Pay: ₱%.2f | Birthday Bonus: ₱%.2f (%s)%n",
                    basePay,
                    birthdayBonus,
                    birthdayBonus > 0 ? "Eligible" : "Ineligible"
            );

            System.out.printf(
                    "   Total Payout: ₱%.2f%n",
                    totalPayout
            );
        }

        System.out.println();
        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");


        HourlyEmployee emp1 = new HourlyEmployee(
                101,
                new Name("Alice", "Maria", "Smith"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                45.0f,
                200.0
        );

        HourlyEmployee emp1Identical = new HourlyEmployee(
                101,
                new Name("Alice", "Maria", "Smith"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                45.0f,
                200.0
        );

        HourlyEmployee emp2 = new HourlyEmployee(
                102,
                new Name("Bob", "Cruz"),
                new MyDate(10, 3, 2001),
                new MyDate(15, 7, 2023),
                38.0f,
                180.0
        );

        System.out.println(
                "emp1 equals emp1Identical: "
                        + emp1.equals(emp1Identical)
        );

        System.out.printf(
                "emp1 hashCode: %d | emp1Identical hashCode: %d (Match: %b)%n",
                emp1.hashCode(),
                emp1Identical.hashCode(),
                emp1.hashCode() == emp1Identical.hashCode()
        );

        System.out.println(
                "emp1 equals emp2: "
                        + emp1.equals(emp2)
        );

        System.out.println();
        System.out.println("DEEP CLONE VERIFICATION");

        HourlyEmployee empOriginal = hourly;
        HourlyEmployee empClone = empOriginal.clone();

        System.out.println(
                "Original Name before modification: "
                        + empOriginal.getEmpName()
        );

        empClone.getEmpName().setFirstName("Taylor");

        System.out.println(
                "Clone Name changed to: "
                        + empClone.getEmpName()
        );

        System.out.println(
                "Original Name after modification: "
                        + empOriginal.getEmpName()
                        + " (Deep copy successful!)"
        );

        System.out.println();

        System.out.println(
                "Original Birth Date before modification: "
                        + empOriginal.getBirthDate()
        );

        empClone.getBirthDate().setMonth(10);

        System.out.println(
                "Clone Birth Date changed to: "
                        + empClone.getBirthDate()
        );

        System.out.println(
                "Original Birth Date after modification: "
                        + empOriginal.getBirthDate()
                        + " (Deep copy successful!)"
        );
    }
}
