package emppay;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class PayrollSystem {
    LinkedList<Employee> employees = new LinkedList<Employee>();

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public void sortEmployees() {
        employees.sort(Comparator.naturalOrder());
    }

    public void calculatePay() {
        for (Employee e : employees) {
            e.calculatePay();
        }
    }

    
    
    
    public void readEmployeeData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\PVSANDEEPGUPTHA\\eclipse-workspace\\Payrole\\src\\emppay\\employee_data"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                char type = data[0].charAt(0);
                int id = Integer.parseInt(data[1]);
                String firstName = data[2];
                String lastName = data[3];
                String title = data[4];
                if (type == 'C') {
                    double salary = Double.parseDouble(data[5]);
                    double commissionRate = Double.parseDouble(data[6]);
                    double commissionSales = Double.parseDouble(data[7]);
                    double threshold = Double.parseDouble(data[8]);
                    CommissionEmployee employee = new CommissionEmployee(id, firstName, lastName, title, salary, commissionRate, commissionSales, threshold);
                    addEmployee(employee);
                } else if (type == 'S') {
                    double salary = Double.parseDouble(data[5]);
                    SalariedEmployee employee = new SalariedEmployee(id, firstName, lastName, title, salary);
                    addEmployee(employee);
                } else if (type == 'H') {
                    double hourlyWage = Double.parseDouble(data[5]);
                    String pt = data[6];
                    double hoursWorked = Double.parseDouble(data[7]);
                    HourlyEmployee employee = new HourlyEmployee(id, firstName, lastName, title, hourlyWage,pt, hoursWorked);
                    addEmployee(employee);
                }

            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    
    

    
    

    public void printReport() {
        double subtotalCommission = 0;
        double subtotalSalaried = 0;
        double subtotalHourly = 0;
        double grandTotal = 0;
        
        
        System.out.println("Commission Based Employees:\n");
        System.out.printf("%-10s %-15s %-13s %-7s %-20s %-20s %-10s\n", "First_Name", "Last_Name", "Title", "ID", "Commission_Rate", "Commission_Sales", "Total_Pay");
        for (Employee e : employees) {
            if (e.getType() == 'C') {
                e.print();
                subtotalCommission += e.getTotalPay();
                grandTotal += e.getTotalPay();
            }
        }
        System.out.println("\nSubtotal: " + subtotalCommission);
        
        System.out.println("\n----------------------------------------------------------------------------------------------");
        
        System.out.println("\nSalaried Employees:\n");
        System.out.printf("%-10s %-15s %-13s %-10s %-10s", "First_Name", "Last_Name", "Title", "ID", "Total_Pay\n");
        for (Employee e : employees) {
            if (e.getType() == 'S') {
                e.print();
                subtotalSalaried += e.getTotalPay();
                grandTotal += e.getTotalPay();
            }
        }
        System.out.println("\nSubtotal: " + subtotalSalaried);
        
        System.out.println("\n----------------------------------------------------------------------------------------------");
        
        
        System.out.println("\nHourly Employees:\n");
        System.out.printf("%-10s %-15s %-13s %-10s %-15s %-10s", "First_Name", "Last_Name", "Title", "ID", "Hourly_Wage", "Total_Pay\n");
        for (Employee e : employees) {
            if (e.getType() == 'H') {
                e.print();
                subtotalHourly += e.getTotalPay();
                grandTotal += e.getTotalPay();
            }
        }
        System.out.println("\nSubtotal: " + subtotalHourly);
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.println("\nGrand Total: " + grandTotal);
        System.out.println("\n----------------------------------------------------------------------------------------------");
        
    }
}
