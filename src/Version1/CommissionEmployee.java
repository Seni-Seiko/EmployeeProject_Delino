package Version1;

public class CommissionEmployee {
    private int empId;
    private String empName;
    private double totalSales;

    public CommissionEmployee() {}

    public CommissionEmployee(int empId, String empName, double totalSales) {
        this.empId = empId;
        this.empName = empName;
        this.totalSales = totalSales;
    }

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public double getTotalSales() { return totalSales; }
    public void setTotalSales(double totalSales) { this.totalSales = totalSales; }

    public double computeSalary() {
        if (totalSales < 50000) {
            return totalSales * 0.05;
        } else if (totalSales < 100000) {
            return totalSales * 0.20;
        } else if (totalSales < 500000) {
            return totalSales * 0.30;
        }
        return totalSales * 0.50;
    }

    public void displayInfo() {
        System.out.println("Commission Employee ID: " + empId + ", Name: " + empName + ", Total Sales: " + totalSales);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Commission Employee ID: ").append(empId)
                .append(", Name: ").append(empName)
                .append(", Total Sales: ").append(totalSales)
                .append(", Salary: ").append(computeSalary());
        return sb.toString();
    }
}
