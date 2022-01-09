import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Account
{
    private int ID; // Account ID //
    private String password; // Account Password //
    private String Username;
    
    protected static int ID_Counter = 0; // static counter to simulate auto increment //
    protected boolean type; // Account type (Student or Admin)
    
    public static ArrayList<Account> Accounts = new ArrayList<>(); // Array List instance to hold all accounts //
    
    @SuppressWarnings("LeakingThisInConstructor")
    public Account()
    {
        this.ID_Counter++;
        this.ID = ID_Counter;
        this.password = "unknown";
        //PrintID();
        Accounts.add(this);
    }
    
    @SuppressWarnings("LeakingThisInConstructor")
    public Account(String username, String pass)
    {
        this.ID_Counter++;
        this.ID = ID_Counter;
        this.Username = username;
        this.password = pass;  
        //PrintID();
        Accounts.add(this);
    }
    
    public static void AddAccount()
    {
        int reply = JOptionPane.showConfirmDialog(null, "Is this Account is going to be an Admin Account ? ", "Account Setup", JOptionPane.YES_NO_OPTION);
        
        if (reply == JOptionPane.YES_OPTION) 
        {
            Admin.Setup_Admin();
        } 
        else 
        {
            Student.Setup_Student();
        }
    }
    
@Override
public boolean equals(Object o) 
{
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    else return false;
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
    
    public static void DeleteAccount(Account act)
    {
        for(int i=0;i<Accounts.size();i++)
        {
          if(act.equals(Accounts.get(i)))
            {
                    System.out.println("Remove Log: "+act.toString()+" -> "+Accounts.get(i).toString()+"");
                    Accounts.remove(i);
            }  
        }
    }
    
    public static void LookForDuplicates()
    {
        Account temp_account = null;
        
        for(int i=0;i<Accounts.size();i++)
        {
            for(int j=0;j<Accounts.size();j++)
            {
                if(temp_account == null)
                {
                    temp_account = Accounts.get(j);
                }
                else
                {
                    if(temp_account.equals( Accounts.get(j)))
                    {
                        System.out.println("Remove Log: "+temp_account.toString()+" -> "+Accounts.get(j).toString()+"");
                        Accounts.remove(j);
                    }
                    temp_account = Accounts.get(j);
                }   
            }
            temp_account = null;
        }   
    }
    
    public static Account FindAccount(String user_name, String pass_word)
    {
        Account act = null;
                
        for(int i=0;i<Accounts.size();i++)
        {
            Account temp = Accounts.get(i);
            
            if(temp.getUsername().equals(user_name) && temp.getPassword().equals(pass_word))
            {
                return temp;
            }
        }
        System.out.println("Could not found account by the given credentials");
        return act;
    }
    
    @Override
    public String toString()
    {
        System.out.println("ID: "+File_Utilities.ANSI_BLUE+""+this.getID()+""+File_Utilities.ANSI_RESET+"");
        System.out.println("Password: "+File_Utilities.ANSI_BLUE+""+this.getPassword()+""+File_Utilities.ANSI_RESET+"");
        
        if(type == false)
        {
            System.out.println("Account Type: "+File_Utilities.ANSI_BLUE+"Student"+File_Utilities.ANSI_RESET+"");
        }
        else
        {
            System.out.println("Account Type: "+File_Utilities.ANSI_BLUE+"Admin"+File_Utilities.ANSI_RESET+"");
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