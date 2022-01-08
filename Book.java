public class Book 
{
    private int ID;
    private String name;
    private String year;
    private String Genre;
    private String Writer;
    
    protected static int ID_Counter;
    protected Account owned = null;
    
    public Book(int id, String name, String year, String genre, String writer_name)
    {
        this.ID_Counter++;
        this.ID = ID_Counter;
        this.name = name;
        this.year = year;
        this.Genre = genre;
        this.Writer = writer_name;
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
    
}
