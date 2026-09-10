package Version1;

public class PieceWorkerEmployee {
    private int empId;
    private String empName;
    private int totalPiecesFinished;
    private float ratePerPiece;

    public PieceWorkerEmployee() {}

    public PieceWorkerEmployee(int empId, String empName, int totalPiecesFinished, float ratePerPiece) {
        this.empId = empId;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public void setTotalPiecesFinished(int totalPiecesFinished) { this.totalPiecesFinished = totalPiecesFinished; }

    public float getRatePerPiece() { return ratePerPiece; }
    public void setRatePerPiece(float ratePerPiece) { this.ratePerPiece = ratePerPiece; }

    public double computeSalary() {
        int bonusPieces = totalPiecesFinished / 100;
        return (totalPiecesFinished * ratePerPiece) + (bonusPieces * (ratePerPiece * 10));
    }

    public void displayInfo() {
        System.out.println("Piece Worker Employee ID: " + empId + ", Name: " + empName + ", Pieces Finished: " + totalPiecesFinished + ", Rate Per Piece: " + ratePerPiece);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Piece Worker Employee ID: ").append(empId)
                .append(", Name: ").append(empName)
                .append(", Pieces Finished: ").append(totalPiecesFinished)
                .append(", Rate Per Piece: ").append(ratePerPiece)
                .append(", Salary: ").append(computeSalary());
        return sb.toString();
    }
}
