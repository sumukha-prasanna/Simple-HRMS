package hrms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class MySQLDatabase {
    private Connection conn;
    private static MySQLDatabase obj;
    private MySQLDatabase()
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/employee";
        String username = "root";
        String password = "1234";
        conn = DriverManager.getConnection(url, username , password);
        createTableIfNotExists();}
        catch(Exception s){}
    }
    public static MySQLDatabase getInstance() {
        if(obj==null)
        {
            obj = new MySQLDatabase();
        }
        return obj;
    }
    public Connection getConnection(){
        return conn;
    }

    private void createTableIfNotExists() throws Exception{
        String sql = "CREATE TABLE IF NOT EXISTS employee (id INT PRIMARY KEY, name VARCHAR(255), designation VARCHAR(255), salary DOUBLE, bonus DOUBLE, tax DOUBLE)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
    }
}
