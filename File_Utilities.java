import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    
    public static String Accounts_Path = Desktop + "/Accounts.txt";
    public static String Books_Path = Desktop + "/Books.txt";
    
    public static void ReadBook(File file)
    {
        int counter = 0;
        String line;
        String[] catcher = null;
        
        //System.out.println("Name Of The File: "+ANSI_BLUE+""+file.getName()+""+ANSI_RESET+"\n");
        
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
                                System.out.println("Unexpected Attributes in line "+counter+"");
                            }
                            else
                            {
                            String Name = catcher[0];
                            String Year = catcher[1];
                            String Genre = catcher[2];
                            String Writer_Name = catcher[3];
                            
                            Book book_temp = new Book(Name,Year,Genre,Writer_Name);
                            }
                            
                        } 
                        counter++;
                    }
                    reader.close();
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
            System.out.println("No Records Found");
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
        //System.out.println("Name Of The File: "+ANSI_BLUE+""+file.getName()+""+ANSI_RESET+"\n");
        
            try(BufferedReader reader = new BufferedReader(new FileReader(file))) 
                {
                    while ((line = reader.readLine()) != null)
                    {
                        if(counter != 0)
                        {
                        line = line.trim();    
                        catcher = line.split(",");
                        
                        if(catcher.length != 3)
                        {
                        System.out.println("Unexpected Attributes in line "+counter+"");
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
                    reader.close();
                }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    
    public static void WriteAccount()
    {
        //Account.LookForDuplicates();
    }
    
    public static void WriteBook() throws FileNotFoundException, IOException
    {
        //Book.LookForDuplicates();
        
        File inputFile = new File(Books_Path);
        File tempFile = new File(Desktop + "/Book.temp");

        int counter = 0;
        String line;
        
            try(BufferedReader reader = new BufferedReader(new FileReader(inputFile)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));) 
                {
                    while ((line = reader.readLine()) != null)
                    {
                        if(counter != 0)
                        {
                            writer.write(line + System.getProperty("line.separator"));   
                        }
                        counter++;
                    }
                    reader.close();
                    writer.close();
                }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        boolean status = tempFile.renameTo(inputFile);
        
        if(status == true)
        {
            System.out.println("Success");
        }
        else
        {
            System.out.println("Failure");
        }
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
        //System.out.println(f.getAbsoluteFile());
        
        if(f.exists()) 
        { 
            ReadAccount(f);
            System.out.println("Accounts File was at expected place: "+ANSI_BLUE+""+f.getAbsolutePath()+""+ANSI_RESET+"");
        }
        else
        {
            System.out.println("Accounts File could not be found. User adjustment required");
            GetFile(false);
        }
    }
    public static void getBooksLocation()
    {
        File f = new File(Books_Path);
        //System.out.println(f.getAbsoluteFile());
        
        if(f.exists()) 
        { 
            ReadBook(f);
            System.out.println("Books File was at expected place: "+ANSI_BLUE+""+f.getAbsolutePath()+""+ANSI_RESET+"");
        }
        else
        {
            System.out.println("Books File could not be found. User adjustment required");
            GetFile(true);
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