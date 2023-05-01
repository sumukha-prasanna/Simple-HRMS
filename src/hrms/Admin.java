
package hrms;

public class Admin implements Observer{
    private String username;
    private static Admin admin;
    private Admin(){
    }
    public static Admin getInstance()
    {
        if(admin==null)
        {
            admin = new Admin();
        }
        return admin;
    }
    public void setUsername(String username)
    {
        if(this.username==null)
        {
            this.username=username;
        }
    }
    @Override
    public void notify(String notification)
    {
        System.out.println(username+":"+notification);
    }
    @Override
    public void notifyError(String error)
    {
        System.out.println(username+":"+error);
    }
}