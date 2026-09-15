package version2;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(lastName);
        result.append(", ");
        result.append(firstName);
        if (middleName != null && !middleName.isEmpty()) {
            result.append(" ");
            result.append(middleName.charAt(0));
            result.append(".");
        }
        if (suffix != null && !suffix.isEmpty()) {
            result.append(" ");
            result.append(suffix);
        }
        return result.toString();
    }
}