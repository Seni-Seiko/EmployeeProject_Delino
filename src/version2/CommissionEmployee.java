
package version2;

public class CommissionEmployee extends version1.CommissionEmployee {

    private Name name;
    private MyDate birthDate;

    public CommissionEmployee(int id, Name name, MyDate birthDate,
                              double grossSales) {

        super(
                id,
                name.toString(),
                grossSales
        );

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
        result.append("\nEmployee Type: Commission Employee");
        result.append("\n").append(super.toString());

        return result.toString();
    }
}

