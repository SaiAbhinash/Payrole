package emppay;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payroll = new PayrollSystem();
        payroll.readEmployeeData();
        payroll.sortEmployees();
        payroll.calculatePay();
        payroll.printReport();
    }
}
