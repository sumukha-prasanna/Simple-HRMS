package hrms;

import java.sql.*;
public class EmployeeController {
    Admin admin = Admin.getInstance();
    MySQLDatabase mydb = MySQLDatabase.getInstance();
    private final Connection conn = mydb.getConnection();
    public boolean checkAdmin(String username , String password) throws Exception
    {
        String sql = "select username from admin where username=? and psword=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,username);
        stmt.setString(2,password);
        ResultSet rs = stmt.executeQuery();
        String temp=null;
        while(rs.next())
        {
            temp=rs.getString("username");
        }
        return temp!=null;
    }
    public void getEmployeeDetails(int id)
    {
        String set = null;
try {
    String sql = "select * from employee where id=?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int sqlid = rs.getInt("id");
                String name = rs.getString("name");
                String designation = rs.getString("designation");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                double tax = rs.getDouble("tax");
                set = "ID:"+sqlid + "\nName:" + name + "\nDesignation:" + designation + "\nSalary:" + salary + "\nBonus:" + bonus + "\nTax:" + tax;
            }
        }
    }
} catch (SQLException e) {
    admin.notifyError("Error occurred: " + e.getMessage());
}
admin.notify(set);

    }
    public void addEmployee (int id , String name , String designation , double salary) throws SQLException
    {
        String sql = "insert into employee values (?,?,?,?,?,?)";
        Employee e = EmployeeFactory.createEmployee(id,name,designation,salary);
        e.setBonus();
        e.setTax();
        double bonus = e.getBonus();
        double tax = e.getTax();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);
        stmt.setString(2,name);
        stmt.setString(3,designation);
        stmt.setDouble(4,salary);
        stmt.setDouble(5,bonus);
        stmt.setDouble(6,tax);
        stmt.execute();
        admin.notify("Employee Added");
    }
    public void removeEmployee(int id) throws SQLException
    {
        String sql = "delete from employee where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);
        stmt.execute();
        admin.notify("Employee removed");
    }
    public void updateEmployee(int id , double salary) throws SQLException
    {
        String sql = "update employee set salary=?,bonus=?,tax=? where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        double bonus = salary*0.3;
        double tax = salary*0.2;
        stmt.setDouble(1,salary);
        stmt.setDouble(2,bonus);
        stmt.setDouble(3,tax);
        stmt.setInt(4,id);
        stmt.execute();
        admin.notify("Employee Updated");
    }
}
