import javax.swing.JOptionPane;

public class Student extends Account
{
    public Student(String username,String pass) 
    {
        super(username,pass);
        super.type = false; // Not Admin - Regular Account //
    }
    public Student()
    {
        super();
        super.type = false;
    }
    
    public static Student Setup_Student()
    {   
        String User_name = null;
        String Password = null;
        
        while(User_name == null)
        {
            User_name = JOptionPane.showInputDialog("Please Enter Student Email");
            
            if(User_name.length() <= 0)
            {
                User_name = null;
            }
        }
        
        while(Password == null)
        {
            Password = JOptionPane.showInputDialog("Please Enter Student Email");
            
            if(Password.length() < 4)
            {
                Password = null;
            }
        }
        return new Student(User_name,Password);
    }
}
