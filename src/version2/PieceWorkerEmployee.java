
package version2;

public class PieceWorkerEmployee extends version1.PieceWorkerEmployee {

    private Name name;
    private MyDate birthDate;

    public PieceWorkerEmployee(int id, Name name, MyDate birthDate, int pieces, float wage) {

        super(id, name.toString(), pieces, wage);

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
        result.append("\nEmployee Type: Piece Worker Employee");
        result.append("\n").append(super.toString());

        return result.toString();
    }
}
