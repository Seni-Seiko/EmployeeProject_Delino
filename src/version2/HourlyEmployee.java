
package version2;

public class HourlyEmployee extends version1.HourlyEmployee {

    private Name name;
    private MyDate birthDate;

    public HourlyEmployee(int id, Name name, MyDate birthDate,
                          float wage, float hours) {

        super(
                id,
                name.toString(),
                wage,
                hours
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
        result.append("\nEmployee Type: Hourly Employee");
        result.append("\n").append(super.toString());

        return result.toString();
    }
}

