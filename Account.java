import java.util.ArrayList;

public class Account
{
    private int ID; // Account ID //
    private String password; // Account Password //
    private String Username;
    
    protected static int ID_Counter = 0; // static counter to simulate auto increment //
    protected boolean type; // Account type (Student or Admin)
    
    public static ArrayList<Account> Accounts = new ArrayList<>();
    
    public Account()
    {
        this.ID_Counter++;
        this.ID = ID_Counter;
        this.password = "unknown";
        //PrintID();
        Accounts.add(this);
    }
    
    public Account(String username, String pass)
    {
        this.ID_Counter++;
        this.ID = ID_Counter;
        this.Username = username;
        this.password = pass;  
        //PrintID();
        Accounts.add(this);
    }
    
    // Getter and Setter for Account Password //
    public String getUsername()
    {
        return this.Username;
    }
    public void setUsername(String uname)
    {
        this.Username = uname;
    }
    
    // Getter and Setter for Account ID //
    public int getID()
    {
        return this.ID;
    }
    public void setID(int id)
    {
        if(id > ID_Counter)
        {
            System.out.println("Duplicate ID");
            return;
        }
        else
        {
            this.ID = id;
        }   
    }
    
    @Override
    public String toString()
    {
        System.out.println("ID: "+this.getID()+"");
        System.out.println("Password: "+this.getPassword()+"");
        
        if(type == false)
        {
            System.out.println("Account Type: Student");
        }
        else
        {
            System.out.println("Account Type: Admin");
        }
        return "\n";
    }
    
    protected void PrintID()
    {
        System.out.println("\n"+ "Your ID is: "+this.ID+" " +"\n");
    }

    // Getter and Setter for Account Password //
    public String getPassword()
    {
        return this.password;
    }
    public void setPassword(String Password)
    {
        if(Password.length() < 4)
        {
            System.out.println("Password Lenght can not be shorter than 4");
            return;
        }
        else
        {
            this.password = Password;
        }
    }
    
    public void checkAccountType() // Inform the user of the account type //
    {
        if(this instanceof Student)
        {
            System.out.println("\n This account is a "+File_Utilities.ANSI_BLUE+" Student Account "+File_Utilities.ANSI_RESET+" \n");
        }
        if(this instanceof Admin)
        {
            System.out.println("\n This account is a "+File_Utilities.ANSI_BLUE+" Admin Account "+File_Utilities.ANSI_RESET+" \n");
        }
        else
        {
            System.out.println("\n "+File_Utilities.ANSI_RED+" Error on Account Type "+File_Utilities.ANSI_RESET+" \n");
        }
    }
}