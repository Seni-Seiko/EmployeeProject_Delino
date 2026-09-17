package version4;

public class EmployeeRoster {

    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this.max = 10;
        this.empList = new Employee[max];
        this.count = 0;
    }

    public EmployeeRoster(int max) {
        if (max > 0) {
            this.max = max;
        } else {
            this.max = 10;
        }

        this.empList = new Employee[this.max];
        this.count = 0;
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) {
            return false;
        }

        empList[count] = emp;
        count++;

        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                Employee removed = empList[i];

                for (int j = i; j < count - 1; j++) {
                    empList[j] = empList[j + 1];
                }

                empList[count - 1] = null;
                count--;

                return removed;
            }
        }

        return null;
    }

    public Employee searchEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        }

        return null;
    }

    public int countHE() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                total++;
            }
        }

        return total;
    }

    public int countPWE() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                total++;
            }
        }

        return total;
    }

    public int countCE() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) {
                total++;
            }
        }

        return total;
    }

    public int countBPCE() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }

        return total;
    }

    public void displayHE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                HourlyEmployee employee =
                        (HourlyEmployee) empList[i];

                employee.displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee employee =
                        (PieceWorkerEmployee) empList[i];

                employee.displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) {
                CommissionEmployee employee =
                        (CommissionEmployee) empList[i];

                employee.displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee) empList[i];

                employee.displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        for (int i = 0; i < count; i++) {
            Employee employee = empList[i];

            System.out.printf(
                    "%d. ID: %d | Name: %s | Type: %s%n",
                    i + 1,
                    employee.getEmpID(),
                    employee.getEmpName(),
                    employee.getClass().getSimpleName()
            );
        }
    }

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < count; i++) {
            Employee employee = empList[i];
            double salary = 0;

            if (employee instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bpce =
                        (BasePlusCommissionEmployee) employee;

                salary = bpce.computeSalary(currentMonth);

                System.out.printf(
                        "[Base Plus Commission] ID: %d | Name: %s | Salary: ₱%.2f%s%n",
                        employee.getEmpID(),
                        employee.getEmpName(),
                        salary,
                        bpce.getBirthDate().getMonth() == currentMonth
                                ? " (Birthday Bonus Applied)"
                                : ""
                );

            } else if (employee instanceof CommissionEmployee) {
                CommissionEmployee ce =
                        (CommissionEmployee) employee;

                salary = ce.computeSalary(currentMonth);

                System.out.printf(
                        "[Commission] ID: %d | Name: %s | Salary: ₱%.2f%s%n",
                        employee.getEmpID(),
                        employee.getEmpName(),
                        salary,
                        ce.getBirthDate().getMonth() == currentMonth
                                ? " (Birthday Bonus Applied)"
                                : ""
                );

            } else if (employee instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee pwe =
                        (PieceWorkerEmployee) employee;

                salary = pwe.computeSalary(currentMonth);

                System.out.printf(
                        "[Piece Worker] ID: %d | Name: %s | Salary: ₱%.2f%s%n",
                        employee.getEmpID(),
                        employee.getEmpName(),
                        salary,
                        pwe.getBirthDate().getMonth() == currentMonth
                                ? " (Birthday Bonus Applied)"
                                : ""
                );

            } else if (employee instanceof HourlyEmployee) {
                HourlyEmployee he =
                        (HourlyEmployee) employee;

                salary = he.computeSalary(currentMonth);

                System.out.printf(
                        "[Hourly] ID: %d | Name: %s | Salary: ₱%.2f%s%n",
                        employee.getEmpID(),
                        employee.getEmpName(),
                        salary,
                        he.getBirthDate().getMonth() == currentMonth
                                ? " (Birthday Bonus Applied)"
                                : ""
                );
            }
        }
    }

    public int getCount() {
        return count;
    }

    public int getMax() {
        return max;
    }
}