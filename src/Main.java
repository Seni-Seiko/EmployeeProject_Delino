import Version1.BasePlusCommissionEmployee;
import Version1.CommissionEmployee;
import Version1.HourlyEmployee;
import Version1.PieceWorkerEmployee;

public class Main {
    public static void main(String[] args) {
        HourlyEmployee hourly = new HourlyEmployee(101, "Delino Hourly", 45.0f, 150.0f);
        CommissionEmployee commission = new CommissionEmployee(102, "Delino Commission", 120000.0);
        BasePlusCommissionEmployee baseComm = new BasePlusCommissionEmployee(103, "Delino BaseComm", 60000.0, 15000.0);
        PieceWorkerEmployee pieceWorker = new PieceWorkerEmployee(104, "Delino PieceWorker", 250, 50.0f);

        System.out.println("DISPLAY INFO:");
        hourly.displayInfo();
        commission.displayInfo();
        baseComm.displayInfo();
        pieceWorker.displayInfo();

        System.out.println("\nTOSTRING W/SALARY:");
        System.out.println(hourly);
        System.out.println(commission);
        System.out.println(baseComm);
        System.out.println(pieceWorker);
    }
}
