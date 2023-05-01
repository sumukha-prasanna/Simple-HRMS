package hrms;

public interface Observer
{
    public void notify(String notification);
    public void notifyError(String error);
}