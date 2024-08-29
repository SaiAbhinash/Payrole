package emppay;

public class CommissionEmployee extends Employee {
    private double salary;
    private double commissionRate;
    private double commissionSales;
    private double threshold;

    public CommissionEmployee(int ID, String firstName, String lastName, String title, double salary, double commissionRate, double commissionSales, double threshold) {
        super(ID, firstName, lastName, title, 'C');
        this.salary = salary;
        this.commissionRate = commissionRate;
        this.commissionSales = commissionSales;
        this.threshold = threshold;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCommissionRate() {
        return commissionRate;
    }
    
    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
    
    public double getCommissionSales() {
        return commissionSales;
    }

    public void setCommissionSales(double commissionSales) {
        this.commissionSales = commissionSales;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public void calculatePay() {
        if (commissionSales >= threshold) {
              setTotalPay(Math.round((salary/24) + ((commissionSales - threshold)* commissionRate)));
        } else {
            setTotalPay(Math.round(salary/24));
        }
    }

    public void print() {
    	System.out.println();
        System.out.printf("%-10s %-15s %-13s %-13s %-20s %-15s %-10s", getFirstName(), getLastName(), getTitle(), getID(), getCommissionRate(), getCommissionSales(), getTotalPay());
        System.out.println();
    }
}
