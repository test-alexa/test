package hw4.formbean;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;

public class RegisterForm {
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	// private String button;

	public RegisterForm(HttpServletRequest request) {
		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		emailAddress = request.getParameter("emailAddress");
		password = request.getParameter("password");
		// button = request.getParameter("button");
	}


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

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (password == null || password.length() == 0)
			errors.add("Password is required");
		if (firstName == null || firstName.length() == 0)
			errors.add("First name is required");
		if (lastName == null || lastName.length() == 0)
			errors.add("Last name is required");
		if (emailAddress == null || emailAddress.length() == 0) {
			errors.add("Email Address is required.");
		}

		// if (isValidEmailAddress(emailAddress) == false)
		// errors.add("Email address is not valid.");

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
