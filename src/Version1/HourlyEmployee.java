package Version1;

public class HourlyEmployee {
    private int empId;
    private String empName;
    private float totalHoursWorked;
    private float ratePerHour;

    public HourlyEmployee() {}

    public HourlyEmployee(int empId, String empName, float totalHoursWorked, float ratePerHour) {
        this.empId = empId;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public float getTotalHoursWorked() { return totalHoursWorked; }
    public void setTotalHoursWorked(float totalHoursWorked) { this.totalHoursWorked = totalHoursWorked; }

    public float getRatePerHour() { return ratePerHour; }
    public void setRatePerHour(float ratePerHour) { this.ratePerHour = ratePerHour; }

    public double computeSalary() {
        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        }
        return (40 * ratePerHour) + ((totalHoursWorked - 40) * ratePerHour * 1.5);
    }

    public void displayInfo() {
        System.out.println("Hourly Employee ID: " + empId + ", Name: " + empName + ", Hours Worked: " + totalHoursWorked + ", Rate: " + ratePerHour);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hourly Employee ID: ").append(empId)
                .append(", Name: ").append(empName)
                .append(", Hours Worked: ").append(totalHoursWorked)
                .append(", Rate: ").append(ratePerHour)
                .append(", Salary: ").append(computeSalary());
        return sb.toString();
    }
}
