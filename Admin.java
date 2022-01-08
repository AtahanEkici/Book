import javax.swing.JOptionPane;

public class Admin extends Account
{
    public Admin(String username,String pass) 
    {
        super(username,pass);
        super.type = true; // Admin Account //
    }
    
    public Admin()
    {
        super();
        super.type = true;
    }
    
    public void AddAccount(Account A)
    {
        
    }
    
    public static Admin Setup_Admin()
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
        return new Admin(User_name,Password);
    }
}