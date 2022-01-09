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
    
    @SuppressWarnings("LeakingThisInConstructor")
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
    
    public static void DeleteBook(Book book)
    {
        for(int i=0;i<Books.size();i++)
        {
            if(book.name.equals(Books.get(i).name) && book.year.equals(Books.get(i).year) && book.Writer.equals(Books.get(i).Writer) && book.Genre.equals(Books.get(i).Genre))
            {
                System.out.println("Remove Log: "+book.toString()+" -> "+Books.get(i).toString()+"");
                Books.remove(i);
            }
        }
    }
    
    public static void LookForDuplicates()
    {
        Book book_temp = null;
        
        for(int i=0;i<Books.size();i++)
        {
            for(int j=0;j<Books.size();j++)
            {
                if(book_temp == null)
                {
                    book_temp = Books.get(j);
                }
                else
                {
                    if(book_temp.name.equals(Books.get(i).name) && book_temp.year.equals(Books.get(i).year) && book_temp.Writer.equals(Books.get(i).Writer) && book_temp.Genre.equals(Books.get(i).Genre))
                    {
                        System.out.println("Remove Log: "+book_temp.toString()+" -> "+Books.get(i).toString()+"");
                        Books.remove(i);
                    }
                    book_temp = Books.get(j);
                }   
            }
            book_temp = null;
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