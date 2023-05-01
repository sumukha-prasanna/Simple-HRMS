package hrms;
public class Employee {
    private int id;
    private String name;
    private String designation;
    private double salary;
    private double bonus;
    private double tax;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus() {
        this.bonus = this.salary*0.3;
    }

    public double getTax() {
        return tax;
    }

    public void setTax() {
        this.tax = this.salary*0.2;
    }
}
