package emppay;

public abstract class Employee implements Comparable<Employee> {
    private int ID;
    private String firstName;
    private String lastName;
    private String title;
    private double totalPay;
    private char type;

    public Employee(int ID, String firstName, String lastName, String title, char type) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.type = type;
        this.totalPay = 0;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int compareTo(Employee other) {
        if (this.type != other.type) {
            return this.type - other.type;
        } else {
            return this.ID - other.ID;
        }
    }
    
//    public int compareTo(Employee o) {
//        if(o.getId()==super.getId()){
//            return 0;
//        }else if(o.getId()>super.getId()){
//            return -1;
//        }else{
//            return 1;
//        }
//    }

    public abstract void calculatePay();

    public abstract void print();

}
