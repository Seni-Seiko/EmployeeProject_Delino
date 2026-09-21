package version6;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale < 0) {
            throw new IllegalArgumentException("Total sales cannot be negative");
        }
        this.totalSale = totalSale;
    }

    public double getCommissionRate() {
        if (totalSale < 50000) {
            return 0.05;
        } else if (totalSale < 100000) {
            return 0.10;
        } else if (totalSale < 500000) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary = totalSale * getCommissionRate();
        return salary + getBirthdayBonus(currentMonth);
    }

    @Override
    public double computeSalary() {
        return computeSalary(-1);
    }

    @Override
    public void displayEmployee() {
        System.out.printf("CommissionEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]%n", getEmpID(), getEmpName(), computeSalary());
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]", getEmpID(), getEmpName(), computeSalary());
    }
}