import java.util.Scanner;

public class Menu 
{
    private static final String create_student = "1";
    private static final String get_all_accounts = "2";
    private static final String get_all_books = "3";
    private static final String print_all_accounts = "4";
    private static final String print_all_books = "5";
    private static final String EOF = "end";
    
    public static void Begin()
    {
        Scanner scanner;
        String input;
        Account act;
        
        System.out.println("Please Login");
        
        while(true)
        {
            System.out.print("Please specify a function: ");
            
            scanner = new Scanner(System.in);
            input = scanner.next();
            
            switch(input)
            {
                case create_student: 
                    //Create Student //
                
                case get_all_accounts:
                   File_Utilities.GetFile(false);
                   break;
                    
                case get_all_books:
                   File_Utilities.GetFile(true);
                   break;
                   
                case print_all_accounts:
                   File_Utilities.PrintArrayList(Account.Accounts);
                   break;
                    
                case print_all_books:
                   File_Utilities.PrintArrayList(Book.Books);
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
    
    public Account Login()
    {
        Scanner scanner = null;
        Account act = null;
        String username = null;
        String password = null;
        
        System.out.println("Please Login Your Account");
        scanner = new Scanner(System.in);
        
        System.out.print("Username: ");
        System.out.print("Password: ");
        
        return act;
    }
}
