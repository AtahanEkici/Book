import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            try {
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

                System.out.println("Please specify a function: ");
                System.out.println("Enter 1 to see your account details");
                System.out.println("Enter 2 for getting Printing All Accounts");
                System.out.println("Enter 3 for getting Printing All Books");
                System.out.println("Enter 4 for getting Adding a Book");
                System.out.println("Enter 5 for getting Adding an Account");
                System.out.println("Enter 6 for Logging Out");
                System.out.println("Enter 7 for Writing Books to the File");
                System.out.println("Enter 8 for Writing Account to the File");
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
                        System.out.println("--- Accounts ---");
                        File_Utilities.PrintArrayList(Account.Accounts);
                        break;
                        
                    case "3":
                        System.out.println("--- Books ---");
                        File_Utilities.PrintArrayList(Book.Books);
                        break;
                    case "4":
                        Book.Setup_Book();
                        break;
                        
                    case "5":
                        Account.AddAccount();
                        break;    
                        
                    case "6":
                        Logout();
                        break;
                        
                    case "7":
                        File_Utilities.WriteBook();
                        break;
                    case "8":
                        File_Utilities.WriteAccount();
                        break;
                        
                    case EOF:
                        System.out.println("User Ended the Program");
                        System.exit(0);
                        break;
                        
                    default:
                        System.out.println("Command not recognized");
                        break;
                }
            } catch (Exception ex)
            {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private static void Student_Panel()
    {
        Scanner scanner = null;
        String input = null;
        
        while(true)
        {
            try {
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
                
                System.out.println("Please specify a function: ");
                System.out.println("Enter 1 to see your account details");
                System.out.println("Enter 3 for getting Printing All Books");
                System.out.println("Enter 4 to Barrow a book");
                System.out.println("Enter 5 to Return a book");
                System.out.println("Enter 6 for Logging Out");
                
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
                        System.out.println("--- Accounts ---");
                        File_Utilities.PrintArrayList(Account.Accounts);
                        break;
                        
                    case "3":
                        System.out.println("--- Books ---");
                        File_Utilities.PrintArrayList(Book.Books);
                        break;
                        
                    case "4":
                        Book.BarrowBook();
                        break;
                    
                    case "5":
                        Book.ReturnBook();
                        break;
                        
                    case "6":
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
            } catch (Exception ex) 
            {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
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
            System.out.println("Program Ended by User input");
            System.exit(0);
        }
        
        System.out.print("Your Password: ");
        password = scanner.next();
        
        if(password.equals(EOF))
        {
            System.out.println("Program Ended by User input");
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
                System.out.println("Entered "+File_Utilities.ANSI_BLUE+" Admin "+File_Utilities.ANSI_RESET+" type account ");
                Admin_Panel();
            }
            else // Student //
            {
                System.out.println("Entered "+File_Utilities.ANSI_BLUE+" Student "+File_Utilities.ANSI_RESET+" type account  ");
                Student_Panel();
            }
        }
    }
}