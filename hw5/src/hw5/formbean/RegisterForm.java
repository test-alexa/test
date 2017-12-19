package hw5.formbean;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
//import javax.servlet.http.HttpServletRequest;
import org.formbeanfactory.FieldOrder;
import org.formbeanfactory.FormBean;
import org.formbeanfactory.InputType;

@FieldOrder("emailAddress, password, firstName, lastName")
public class RegisterForm extends FormBean {
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	// private String button;

	public void setEmailAddress(String s)  { emailAddress = s.trim(); }
    @InputType("password")
    public void setPassword(String s)  { password = s.trim(); 	}
    public void setFirstName(String s) {	firstName = s.trim();	}
    public void setLastName(String s)	{	lastName = s.trim();	}
    
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	
	public void validate() {
        super.validate();
        if (hasValidationErrors()) {
            return;
        }
        if (password.matches(".*[<>\"].*")) {
            this.addFieldError("password", "May not contain angle brackets or quotes");
        }        
        if (emailAddress.matches(".*[<>\"].*")) {
            this.addFieldError("userName", "May not contain angle brackets or quotes");
        }
    }
}
