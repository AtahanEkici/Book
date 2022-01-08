public class Account
{
    private int ID; // Account ID //
    private String Email; // Account Email //
    private String password; // Account Password //
    
    protected static int ID_Counter = 0; // static counter to simulate auto increment //
    protected boolean type; // Account type (Student or Admin)
    
    public Account()
    {
        this.ID_Counter++;
        this.ID = ID_Counter;
        this.Email = "unknown@mail.com";
        this.password = "unknown";
    }
    
    public Account(String email, String pass)
    {
        this.ID_Counter++;
        this.ID = ID_Counter;
        this.Email = email;
        this.password = pass;  
    }
    // Getter and Setter for Account ID //
    public int getID()
    {
        return this.ID;
    }
    public void setID(int id)
    {
        if(ID_Counter > id)
        {
            System.out.println("Duplicate ID");
            return;
        }
        else
        {
            this.ID = id;
        }   
    }
    // Getter and Setter for Account's Email //
    public String getEmail()
    {
        return this.Email;
    }
    public void setEmail(String mail)
    {
        if(!mail.contains("@"))
        {
            System.out.println("Error unsopported mail type");
            return;
        }
        else
        {
            this.Email = mail;
        }
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