package hw4.databean;

import org.genericdao.PrimaryKey;

@PrimaryKey("email")


public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public String getPassword()        { return password; }
    public String getFirstName()        { return firstName; }
    public String getLastName()        { return lastName; }
    public String getEmail()        { return email; }

    public void setPassword(String s)  { password = s;    }
    public void setFirstName(String s)  { firstName = s;  }
    public void setLastName(String s)  { lastName = s;    }
    public void setEmail(String s)  {  email = s;  }
}
