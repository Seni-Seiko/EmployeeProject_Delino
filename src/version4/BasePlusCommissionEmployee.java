package version4;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate,
                                      MyDate dateHired, double totalSale,
                                      double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        }
    }

    public double computeSalary() {
        return baseSalary + super.computeSalary();
    }

    public double computeSalary(int currentMonth) {
        double salary = computeSalary();

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000.00;
        }

        return salary;
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sales: ₱%.2f | Base Salary: ₱%.2f%n",
                getEmpID(),
                getEmpName(),
                getBirthDate(),
                getDateHired(),
                getTotalSale(),
                baseSalary
        );
    }

    @Override
    public String toString() {
        return String.format(
                "BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Total Sales: ₱%.2f, Base Salary: ₱%.2f]",
                getEmpID(),
                getEmpName(),
                getBirthDate(),
                getDateHired(),
                getTotalSale(),
                baseSalary
        );
    }
}