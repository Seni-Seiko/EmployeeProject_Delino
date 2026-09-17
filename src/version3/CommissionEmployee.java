package version3;

import java.util.Objects;

public class CommissionEmployee extends Employee {

    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate,
                              MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        }
    }

    public double getCommissionRate() {
        if (totalSale < 50000) {
            return 0.05;
        } else if (totalSale < 100000) {
            return 0.10;
        } else if (totalSale < 500000) {
            return 0.15;
        }

        return 0.20;
    }

    @Override
    public double computeSalary() {
        return totalSale * getCommissionRate();
    }

    @Override
    public double computeSalary(int currentMonth) {
        return computeSalary() + super.computeSalary(currentMonth);
    }

    public void displayCommissionEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sales: ₱%.2f | Commission Rate: %.0f%%%n",
                getEmpID(),
                getEmpName(),
                getBirthDate(),
                getDateHired(),
                totalSale,
                getCommissionRate() * 100
        );
    }

    @Override
    public String toString() {
        return String.format(
                "CommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Total Sales: ₱%.2f, Commission Rate: %.0f%%]",
                getEmpID(),
                getEmpName(),
                getBirthDate(),
                getDateHired(),
                totalSale,
                getCommissionRate() * 100
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof CommissionEmployee)) {
            return false;
        }

        CommissionEmployee other = (CommissionEmployee) obj;

        return Double.compare(totalSale, other.totalSale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalSale);
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
    }
}