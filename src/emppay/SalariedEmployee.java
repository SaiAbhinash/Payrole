package emppay;

public class SalariedEmployee extends Employee {
    private double salary;

    public SalariedEmployee(int ID, String firstName, String lastName, String title, double salary) {
        super(ID, firstName, lastName, title, 'S');
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void calculatePay() {
        setTotalPay(Math.round(salary/24));
    }

    public void print() {
    	System.out.println();
        System.out.printf("%-10s %-15s %-13s %-10s %-10s", getFirstName(), getLastName(), getTitle(), getID(), getTotalPay());
        System.out.println();
    }
}
