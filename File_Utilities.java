import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class File_Utilities 
{
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    
    public static final String Desktop = System.getProperty("user.home")+"/Desktop";
    
    public static String Accounts_Path = Desktop + "Accounts.txt";
    public static String Books_Path = Desktop + "Books.txt";
    
    public static void ReadBook(File file)
    {
        int counter = 0;
        String line;
        String[] catcher = null;
        
        System.out.println("Name Of The File: "+ANSI_BLUE+""+file.getName()+""+ANSI_RESET+"\n");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
                {
                    while ((line = reader.readLine()) != null)
                    {
                        if(counter != 0)
                        {
                            line = line.trim();
                            catcher = line.split(",");
                        
                            if(catcher.length != 4)
                            {
                                System.out.println("Unexpected Attributes");
                                return;
                            }
                            
                            String Name = catcher[0];
                            String Year = catcher[1];
                            String Genre = catcher[2];
                            String Writer_Name = catcher[3];
                            
                            Book book_temp = new Book(Name,Year,Genre,Writer_Name);
                        } 
                        counter++;
                    }
                }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void PrintArrayList(ArrayList list)
    {
        if(list.size() <= 0)
        {
            System.out.println("No Accounts registered");
        }
        else
        {
            for(int i=0;i<list.size();i++)
            {
                System.out.println(list.get(i).toString());
            }
        }  
    }
    
    public static void ReadAccount(File file)
    {
        int counter = 0;
        String line;
        String[] catcher = null;
        System.out.println("Name Of The File: "+ANSI_BLUE+""+file.getName()+""+ANSI_RESET+"\n");
        
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
                {
                    while ((line = reader.readLine()) != null)
                    {
                        if(counter != 0)
                        {
                        line = line.trim();    
                        catcher = line.split(",");
                        
                        if(catcher.length != 3)
                        {
                        System.out.println("Unexpected Attributes");
                        return;
                        }
                        
                        String Username = catcher[0];
                        String Password = catcher[1];
                        boolean type = Boolean.parseBoolean(catcher[2]);
                        
                        if(type == false) // Student //
                        {
                            Student student_temp = new Student(Username,Password);
                        }
                        else // Admin //
                        {
                            Admin admin_temp = new Admin(Username,Password);
                        }
                        } 
                        counter++;
                    }
                }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    
    public static void WriteAccount()
    {
        
    }
    
    public static void WriteBook()
    {
        
    }
    
    public static void PrintArray(Object[] array)
    {
        for(int i=0;i<array.length;i++)
        {
            System.out.println(""+(i+1)+")" + array[i]);
        }
    }
    
    public static void getAccountsLocation()
    {
        File f = new File(File_Utilities.Accounts_Path);
        
        if(f.exists() && !f.isDirectory()) 
        { 
            System.out.println("Accounts File was at expected place");
        }
        else
        {
            System.out.println("Accounts File could not be found. User adjustment required");
            File_Utilities.GetFile(false);
        }
    }
    
    public static File GetFile(boolean Switch) // false for account true for book //
    {
    JFileChooser jfc = new JFileChooser(Desktop);
    jfc.requestFocusInWindow();
    jfc.setMultiSelectionEnabled(false);
    jfc.setFileFilter(new FileNameExtensionFilter("Text Files","txt"));
    int result = jfc.showSaveDialog(null);
    
    if(result == JFileChooser.APPROVE_OPTION)
        {
            File file = jfc.getSelectedFile();
            
            if(Switch == false)
            {
                ReadAccount(file);
                Accounts_Path = file.getAbsolutePath();
                System.out.println(Accounts_Path);
            }
            else
            {
                ReadBook(file);
                Books_Path = file.getAbsolutePath();
                System.out.println(Books_Path);
            }
            return file;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"File Selection error","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    return null;
    }
}