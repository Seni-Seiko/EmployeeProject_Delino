package version4;

public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate,
                          MyDate dateHired, float totalHoursWorked,
                          double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        }
    }

    public double computeSalary() {
        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        }

        return (40 * ratePerHour)
                + ((totalHoursWorked - 40) * ratePerHour * 1.5);
    }

    public double computeSalary(int currentMonth) {
        double salary = computeSalary();

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000.00;
        }

        return salary;
    }

    public void displayHourlyEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | DOB: %s | Hired: %s | Hours: %.2f | Rate: ₱%.2f%n",
                getEmpID(),
                getEmpName(),
                getBirthDate(),
                getDateHired(),
                totalHoursWorked,
                ratePerHour
        );
    }

    @Override
    public String toString() {
        return String.format(
                "HourlyEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Hours: %.2f, Rate: ₱%.2f]",
                getEmpID(),
                getEmpName(),
                getBirthDate(),
                getDateHired(),
                totalHoursWorked,
                ratePerHour
        );
    }
}