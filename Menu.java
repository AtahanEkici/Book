import java.util.Scanner;

public class Menu 
{
    private static final String EOF = "end";
    
    protected static Account Logged_Account = null;
    
    private static void Admin_Panel()
    {
        Scanner scanner = null;
        String input = null;
        
        while(true)
        {
            if(Logged_Account == null)
            {
                System.out.println("\n Please Enter 1 for Login Enter Anything else to exit");
                Scanner scanned = new Scanner(System.in);
                
                if("1".equals(scanned.next().trim()))
                {
                    Login();
                }
                else
                {
                    System.exit(0);
                }
            }
            
            System.out.print("Please specify a function: ");
            System.out.println("Enter 1 to see your account details");
            System.out.println("Enter 2 for getting Printing All Accounts");
            System.out.println("Enter 3 for getting Printing All Books");
            System.out.println("Enter 4 for Logging Out");
            System.out.print("Your choice: ");
            
            scanner = new Scanner(System.in);
            input = scanner.next();
            
            switch(input.trim())
            {
                case "1": 
                    System.out.print("\n--- Account Details ---");
                    System.out.println(Logged_Account.toString());
                    break;
                   
                case "2":
                   File_Utilities.PrintArrayList(Account.Accounts);
                   break;
                    
                case "3":
                   File_Utilities.PrintArrayList(Book.Books);
                   break;  
                   
                case "4":
                   Logout();
                   break;

                case EOF:
                    System.out.println("User Ended the Program");
                    System.exit(0);
                    break;   
                    
                default:
                    System.out.println("Command not recognized"); 
                    break;
            }
        }
    }
    
    private static void Student_Panel()
    {
        Scanner scanner = null;
        String input = null;
        
        while(true)
        {
            if(Logged_Account == null)
            {
                System.out.println("Enter 1 for Login Enter Anything else to exit");
                scanner = new Scanner(System.in);
                
                if("1".equals(scanner.next().trim()))
                {
                    Login();
                }
                else
                {
                    System.exit(0);
                }
            }
            
            System.out.print("Please specify a function: ");
            System.out.println("Enter 1 to see your account details");
            System.out.println("Enter 2 for getting Printing All Accounts");
            System.out.println("Enter 3 for getting Printing All Books");
            System.out.println("Enter 4 for Logging Out");
            System.out.println("Entering 'end'(without the ' character) will exit the program");
            
            scanner = new Scanner(System.in);
            input = scanner.next();
            
            switch(input.trim())
            {
                case "1": 
                   System.out.print("\n--- Account Details ---");
                    System.out.println(Logged_Account.toString());
                    break;
                   
                case "2":
                   File_Utilities.PrintArrayList(Account.Accounts);
                   break;
                    
                case "3":
                   File_Utilities.PrintArrayList(Book.Books);
                   break;  
                   
                case "4":
                   Logout();
                   break;

                case EOF:
                    System.out.println("User Ended the Program");
                    System.exit(0);
                    break;   
                    
                default:
                    System.out.println("Command not recognized"); 
                    break;
            }
        }
    }
    
    public static void Begin()
    {
        Login();   
    }
    
    public static void Logout()
    {
        Logged_Account = null;
        System.out.println("Logged Out");
    }
    
    public static void Login()
    {
        Scanner scanner = null;
        String username = null;
        String password = null;
        
        File_Utilities.getAccountsLocation();
        File_Utilities.getBooksLocation();
        
        System.out.println("Please Login to Your Account");
        scanner = new Scanner(System.in);
        
        System.out.print("Your Username: ");
        username = scanner.next();
        
        if(username.equals(EOF))
        {
            System.exit(0);
        }
        
        System.out.print("Your Password: ");
        password = scanner.next();
        
        if(password.equals(EOF))
        {
            System.exit(0);
        }
        
        Logged_Account = Account.FindAccount(username, password);
        
        if(Logged_Account == null)
        {
            Login();
        }
        else
        {
            if(Logged_Account.type == true) // Admin //
            {
                System.out.println("Entered Admin type account");
                Admin_Panel();
            }
            else // Student //
            {
                System.out.println("Entered Student type account");
                Student_Panel();
            }
        }
    }
}