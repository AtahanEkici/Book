public class Student extends Account
{
    public Student(String email, String pass) 
    {
        super(email, pass);
        super.type = false; // Not Admin - Regular Account //
    } 
}
