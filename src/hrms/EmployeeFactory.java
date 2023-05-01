package hrms;

public class EmployeeFactory {
    public static Employee createEmployee(int id , String name, String designation , double salary) {
        return new Employee(id , name, designation , salary);
    }
}
