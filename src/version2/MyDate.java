
package version2;

public class MyDate {

    private int day;
    private int month;
    private int year;

    private static final String[] MONTHS = {
            "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec"
    };

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean isBirthMonth(MyDate currentDate) {
        return month == currentDate.month;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        if (day < 10) {
            result.append("0");
        }

        result.append(day);
        result.append(" ");

        result.append(MONTHS[month - 1]);

        result.append(" ");
        result.append(year);

        return result.toString();
    }
}

