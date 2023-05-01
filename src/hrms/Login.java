package hrms;
public class Login
{
    public boolean checkAdmin(String username , String password)throws Exception
    {
        EmployeeController ec = new EmployeeController();
        boolean check = ec.checkAdmin(username , password);
        if(check)
        {
            Admin admin = Admin.getInstance();
            admin.setUsername(username);
        }
        return check;
    }
}