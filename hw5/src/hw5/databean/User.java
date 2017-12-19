package hw5.databean;

import org.genericdao.PrimaryKey;

@PrimaryKey("emailAddress")


public class User {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;

    public String getPassword()        { return password; }
    public String getFirstName()        { return firstName; }
    public String getLastName()        { return lastName; }
    public String getEmailAddress()        { return emailAddress; }

    public void setPassword(String s)  { password = s;    }
    public void setFirstName(String s)  { firstName = s;  }
    public void setLastName(String s)  { lastName = s;    }
    public void setEmailAddress(String s)  {  emailAddress = s;  }
}
