import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class File_Utilities 
{
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    
    public static Object[] ReadFile(File file)
    {
        String line;
        String[] catcher = null;
        System.out.println("Name Of The File: "+ANSI_BLUE+""+file.getName()+""+ANSI_RESET+"\n");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
                {
                    while ((line = reader.readLine()) != null)
                    {
                        catcher = line.split(",");
                        PrintArray(catcher);
                        System.out.println("\n --- Line End --- "+"\n");
                        //System.out.println(Arrays.toString(catcher));
                    }
                }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return catcher;
    }
    
    public static void PrintArray(Object[] array)
    {
        for(int i=0;i<array.length;i++)
        {
            System.out.println(""+(i+1)+")" + array[i]);
        }
    }
    
    public static File GetFile()
    {
    JFileChooser jfc = new JFileChooser(System.getProperty("user.home") +"/Desktop");
    jfc.setMultiSelectionEnabled(false);
    jfc.setFileFilter(new FileNameExtensionFilter("Text Files","txt"));
    int result = jfc.showSaveDialog(null);
    
    if(result == JFileChooser.APPROVE_OPTION)
        {
            File file = jfc.getSelectedFile();
            ReadFile(file);
            return file;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"File Selection error","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    return null;
    }
}