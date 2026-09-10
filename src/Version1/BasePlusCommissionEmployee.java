package Version1;

public class BasePlusCommissionEmployee {
    private int empId;
    private String empName;
    private double totalSales;
    private double baseSalary;

    public BasePlusCommissionEmployee() {}

    public BasePlusCommissionEmployee(int empId, String empName, double totalSales, double baseSalary) {
        this.empId = empId;
        this.empName = empName;
        this.totalSales = totalSales;
        this.baseSalary = baseSalary;
    }

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public double getTotalSales() { return totalSales; }
    public void setTotalSales(double totalSales) { this.totalSales = totalSales; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    public double computeSalary() {
        double commission;
        if (totalSales < 50000) {
            commission = totalSales * 0.05;
        } else if (totalSales < 100000) {
            commission = totalSales * 0.20;
        } else if (totalSales < 500000) {
            commission = totalSales * 0.30;
        } else {
            commission = totalSales * 0.50;
        }
        return baseSalary + commission;
    }

    public void displayInfo() {
        System.out.println("Base Plus Commission Employee ID: " + empId + ", Name: " + empName + ", Total Sales: " + totalSales + ", Base Salary: " + baseSalary);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Base Plus Commission Employee ID: ").append(empId)
                .append(", Name: ").append(empName)
                .append(", Total Sales: ").append(totalSales)
                .append(", Base Salary: ").append(baseSalary)
                .append(", Total Earnings: ").append(computeSalary());
        return sb.toString();
    }
}
