import version2.BasePlusCommissionEmployee;
import version2.CommissionEmployee;
import version2.HourlyEmployee;
import version2.MyDate;
import version2.Name;
import version2.PieceWorkerEmployee;

public class Main2 {

    public static void main(String[] args) {

        Name name1 = new Name("Andrae", "Zyril", "Delino", "");
        MyDate date1 = new MyDate(8, 9, 2006);

        Name name2 = new Name("John", "Paul", "Smith", "Jr.");
        MyDate date2 = new MyDate(15, 9, 2005);

        Name name3 = new Name("Maria", "", "Santos", "");
        MyDate date3 = new MyDate(20, 3, 2004);

        Name name4 = new Name("James", "Robert", "Cruz", "III");
        MyDate date4 = new MyDate(10, 12, 2003);

        HourlyEmployee hourly = new HourlyEmployee(101, name1, date1, 45.0f, 150.0f);
        CommissionEmployee commission = new CommissionEmployee(102, name2, date2, 120000.0);
        BasePlusCommissionEmployee baseComm = new BasePlusCommissionEmployee(103, name3, date3, 60000.0, 15000.0);

        PieceWorkerEmployee pieceWorker = new PieceWorkerEmployee(104, name4, date4, 250, 50.0f);
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

        System.out.println("\nBIRTHDAY CHECK:");

        MyDate currentDate = new MyDate(15, 9, 2026);

        System.out.println(hourly.getName() + ": " + hourly.getBirthDate().isBirthMonth(currentDate));

        System.out.println(commission.getName() + ": " + commission.getBirthDate().isBirthMonth(currentDate));

        System.out.println(baseComm.getName() + ": " + baseComm.getBirthDate().isBirthMonth(currentDate));

        System.out.println(pieceWorker.getName() + ": " + pieceWorker.getBirthDate().isBirthMonth(currentDate));
    }
}
