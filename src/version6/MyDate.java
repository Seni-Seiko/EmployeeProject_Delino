package version6;

import java.util.Objects;

public final class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    public MyDate() {
        this(1, 1, 2000);
    }

    public MyDate(int day, int month, int year) {
        validateDate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        validateDate(day, this.month, this.year);
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        validateDate(this.day, month, this.year);
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        validateDate(this.day, this.month, year);
        this.year = year;
    }

    private static void validateDate(int day, int month, int year) {
        if (month < 1 || month > 12 || year <= 1900) {
            throw new IllegalArgumentException("Invalid calendar date");
        }
        int maxDay;
        switch (month) {
            case 2:
                maxDay = isLeapYear(year) ? 29 : 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                maxDay = 30;
                break;
            default:
                maxDay = 31;
        }
        if (day < 1 || day > maxDay) {
            throw new IllegalArgumentException("Invalid calendar date");
        }
    }

    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public boolean isBirthMonth(int currentMonth) {
        return month == currentMonth;
    }

    @Override
    public String toString() {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return String.format("%02d %s %d", day, months[month - 1], year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyDate)) return false;
        MyDate other = (MyDate) obj;
        return day == other.day && month == other.month && year == other.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}