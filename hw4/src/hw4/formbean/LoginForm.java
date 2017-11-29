package hw4.formbean;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;

public class LoginForm {
//	private String userName;
	private String emailAddress;
	private String password;


	public LoginForm(HttpServletRequest request) {
//		userName = request.getParameter("userName");
		emailAddress = request.getParameter("emailAddress");
		password = request.getParameter("password");
		//button = request.getParameter("button");
	}
//	public String getUserName() {
//		return userName;
//	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getPassword() {
		return password;
	}
	/*
	public String getButton() {
		return button;
	}

	public boolean isPresent() {
		return button != null;
	}
*/
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

//		if (userName == null || userName.length() == 0)
//			errors.add("User Name is required.");
		if (password == null || password.length() == 0)
			errors.add("Password is required.");
		if (emailAddress == null || emailAddress.length() == 0) {
			errors.add("Email Address is required.");
		}
//		if (isValidEmailAddress(emailAddress) == false)
//			errors.add("Email address is not valid.");

		if (errors.size() > 0)
			return errors;

		return errors;
	}
	
	public static boolean isValidEmailAddress(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}
}

