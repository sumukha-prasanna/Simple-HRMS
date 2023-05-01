package hrms;
import java.util.*;
public class Main
{
    public static void main(String args[]) throws Exception
    {
        System.out.println("-------Login-------");
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        while(!check){
        System.out.println("Enter username:");
        String name = sc.nextLine();
        System.out.println("Enter Password:");
        String password = sc.nextLine();
        Login lg = new Login();
        check = lg.checkAdmin(name, password);
        }
        EmployeeView ev = new EmployeeView();
        ev.display();
    }
}