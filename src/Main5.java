import version5.*;

public class Main5 {
    public static void main(String[] args) {
        EmployeeRoster roster = new EmployeeRoster();
        Employee hourly = new HourlyEmployee(101, new Name("Alice", "Maria", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200);
        Employee pieceWorker = new PieceWorkerEmployee(201, new Name("Bob", "Carlos", "Jones", "Jr."), new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 90, 45);
        Employee commission = new CommissionEmployee(301, new Name("Maria", "Lopez", "Reyes"), new MyDate(20, 9, 2001), new MyDate(10, 2, 2023), 100000);
        Employee basePlus = new BasePlusCommissionEmployee(401, new Name("Kevin", "Samuel", "Tan"), new MyDate(12, 5, 1999), new MyDate(8, 7, 2022), 60000, 15000);
        System.out.println("======================================================================");
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println("======================================================================");
        roster.addEmployee(hourly);
        System.out.println("Enrolled: " + hourly.getEmpName() + " (Hourly)");
        roster.addEmployee(pieceWorker);
        System.out.println("Enrolled: " + pieceWorker.getEmpName() + " (Piece Worker)");
        roster.addEmployee(commission);
        System.out.println("Enrolled: " + commission.getEmpName() + " (Commission)");
        roster.addEmployee(basePlus);
        System.out.println("Enrolled: " + basePlus.getEmpName() + " (Base Plus Commission)");
        System.out.println("Total Roster Size: " + roster.countEmployees() + " employees");
        System.out.println();
        System.out.println("======================================================================");
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");
        roster.displayPayroll(9);
        System.out.println();
        System.out.println("======================================================================");
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println("======================================================================");
        System.out.print("Removing Employee ID 201... ");
        Employee removed = roster.removeEmployee(201);
        if (removed != null) {
            System.out.println("Successfully removed.");
        } else {
            System.out.println("Employee not found.");
        }
        System.out.println("Updated Roster Size: " + roster.countEmployees());
        System.out.println();
        System.out.println("Current Active Employees:");
        int number = 1;
        for (int i = 0; i < roster.countEmployees(); i++) {
            Employee employee;
            if (i == 0) {
                employee = roster.searchEmployee(101);
            } else if (i == 1) {
                employee = roster.searchEmployee(301);
            } else {
                employee = roster.searchEmployee(401);
            }
            if (employee != null) {
                System.out.println(number + ". " + employee);
                number++;
            }
        }
        System.out.println("======================================================================");
    }
}