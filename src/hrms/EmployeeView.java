package hrms;
import java.util.*;

public class EmployeeView {
    public void display() throws Exception
    {
        EmployeeController ec = new EmployeeController();
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Add Employee");
        System.out.println("2.Remove Employee");
        System.out.println("3.View Employee");
        System.out.println("4.Update Employee");
        System.out.println("5.Exit");
        System.out.println("Enter the respective number");
        int n = sc.nextInt();
        int id;
        double salary;
        switch(n)
        {
            case 1:
                System.out.println("Enter id:");
                id= sc.nextInt();
                sc.nextLine();
                System.out.println("Enter name:");
                String name = sc.nextLine();
                System.out.println("Enter designation:");
                String designation = sc.nextLine();
                System.out.println("Enter salary");
                salary = sc.nextDouble();
                ec.addEmployee(id, name , designation , salary);
                break;
            case 2:
                System.out.println("Enter id:");
                id = sc.nextInt();
                ec.removeEmployee(id);
                break;
            case 3:
                System.out.println("Enter id:");
                id = sc.nextInt();
                ec.getEmployeeDetails(id);
                break;
            case 4:
                System.out.println("Enter id:");
                id = sc.nextInt();
                System.out.println("Enter salary:");
                salary = sc.nextDouble();
                ec.updateEmployee(id,salary);
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Wrong input provided");
                break;
        }
        Thread.sleep(4000);
        display();
    }
}
