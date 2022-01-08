import java.util.ArrayList;

public class Book 
{
    private int ID;
    private String name;
    private String year;
    private String Genre;
    private String Writer;
    
    protected static int ID_Counter;
    public static ArrayList<Book> Books = new ArrayList<>();

    protected Account owned_by = null;
    
    public Book(String name, String year, String genre, String writer_name)
    {
        this.ID_Counter++;
        this.ID = ID_Counter;
        this.name = name;
        this.year = year;
        this.Genre = genre;
        this.Writer = writer_name;
        //this.PrintID();
        Books.add(this);
    }
    
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
    
    @Override
    public String toString()
    {
        System.out.println("ID: "+this.getID()+"");
        System.out.println("Name: "+this.getName()+"");
        System.out.println("Year: "+this.getYear()+"");
        System.out.println("Genre: "+this.getGenre()+"");
        return "\n";
    }
    
    protected void PrintID()
    {
        System.out.println("\n"+ "Your ID is: "+this.ID+" " +"\n");
    }
    
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getYear()
    {
        return this.year;
    }
    public void setYear(String year)
    {
        this.year = year;
    }
    
    public String getGenre()
    {
        return this.Genre;
    }
    public void setGenre(String genre)
    {
        this.Genre = genre;
    }
    
    public String getWriter()
    {
        return this.Writer;
    }
    public void setWriter(String writer)
    {
        this.Writer = writer;
    }
    
    public void SetOwner(Account act,boolean status)
    {
        if(owned_by == null) // does not have an owner //
        {
            owned_by = act;
        }
        else if(owned_by != null && owned_by == act)
        {
            if(status == true) // owner returns the book //
            {
                owned_by = null;
            }
        }
        else
        {
            System.out.println("The book is not available to public");
        }
    }
}