public class Admin extends Account
{
    public Admin(String email, String pass) 
    {
        super(email, pass);
        super.type = true; // Admin Account //
    }
}
