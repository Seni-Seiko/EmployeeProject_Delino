package version5;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished >= 0 ? totalPiecesFinished : 0;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece >= 0 ? ratePerPiece : 0;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary = totalPiecesFinished * ratePerPiece;
        int bonusPieces = totalPiecesFinished / 100;
        salary += bonusPieces * 10 * ratePerPiece;
        if (getBirthDate().isBirthMonth(currentMonth)) {
            salary += 5000;
        }
        return salary;
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]", getEmpID(), getEmpName(), computeSalary());
    }
}