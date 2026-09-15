
package version2;

public class BasePlusCommissionEmployee extends version1.BasePlusCommissionEmployee {

    private Name name;
    private MyDate birthDate;

    public BasePlusCommissionEmployee(int id, Name name, MyDate birthDate, double grossSales, double baseSalary) {

        super(id, name.toString(), grossSales, baseSalary);

        this.name = name;
        this.birthDate = birthDate;
    }

    public Name getName() {
        return name;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        result.append("Name: ").append(name);
        result.append("\nBirth Date: ").append(birthDate);
        result.append("\nEmployee Type: Base Plus Commission Employee");

        return result.toString();
    }
}
