package hw5.formbean;

//import java.util.ArrayList;
//import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
//import javax.servlet.http.HttpServletRequest;
import org.formbeanfactory.FieldOrder;
import org.formbeanfactory.FormBean;
import org.formbeanfactory.InputType;

@FieldOrder("emailAddress,password")
public class LoginForm extends FormBean {
	
	private String emailAddress;
	private String password;

	public void setEmailAddress(String s)  { emailAddress = s.trim(); }
    @InputType("password")
    public void setPassword(String s)  { password = s.trim(); }
    
    
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public String getPassword() {
		return password;
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

