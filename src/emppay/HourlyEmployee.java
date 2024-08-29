package emppay;

public class HourlyEmployee extends Employee {
    private double hourlyWage;
    private String Overtime;
    private double hoursWorked;

    public HourlyEmployee(int ID, String firstName, String lastName, String title, double hourlyWage,String Overtime, double hoursWorked) {
        super(ID, firstName, lastName, title, 'H');
        this.hourlyWage = hourlyWage;
        this.Overtime=Overtime;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void calculatePay() {
        double overtime = 0;
        if (hoursWorked > 80 && Overtime == "Y") {
            overtime = (hoursWorked - 80) * (hourlyWage * 1.5);
        }
        setTotalPay(Math.round((hoursWorked * hourlyWage) + overtime));
    }

    public void print() {
    	System.out.println();
        System.out.printf("%-10s %-15s %-13s %-10s %-16s %-10s", getFirstName(), getLastName(), getTitle(), getID(), getHourlyWage(), getTotalPay());
        System.out.println();
    }
}
