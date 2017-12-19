package hw5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.formbeanfactory.FormBeanFactory;
import org.genericdao.DuplicateKeyException;
import org.genericdao.RollbackException;

import hw5.dao.*;
import hw5.databean.*;
import hw5.formbean.*;

public class LoginAction extends Action {
    private FormBeanFactory<LoginForm> formBeanFactory = new FormBeanFactory<>(LoginForm.class);

    private UserDAO userDAO;

    public LoginAction(Model model) {
        userDAO = model.getUserDAO();
    }

    public String getName() {
        return "login.do";
    }

    public String performGet(HttpServletRequest request) {
        // If user is already logged in, redirect to homepage.do
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "homepage.do";
        }

        // Otherwise, just display the login page.
        request.setAttribute("form", new LoginForm());
        try{
        	request.setAttribute("users", userDAO.getUser());
        } catch (RollbackException e) {
        	
        }
        return "login.jsp";
    }

    public String performPost(HttpServletRequest request) {
        // If user is already logged in, redirect to homepage.do
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "homepage.do";
        }

        try {
            LoginForm form = formBeanFactory.create(request);
            request.setAttribute("form", form);

            // Any validation errors?
            if (form.hasValidationErrors()) {
                return "login.jsp";
            }

            // Look up the user
            User user = userDAO.read(form.getEmailAddress());

            if (user == null) {
                form.addFieldError("emailAddress", "User Email not found");
                return "login.jsp";
            }

            // Check the password
            if (!user.getPassword().equals(form.getPassword())) {
                form.addFieldError("password", "Incorrect password");
                return "login.jsp";
            }

            // Attach (this copy of) the user bean to the session
            session.setAttribute("user", user);

            // If redirectTo is null, redirect to the "homepage" action
            return "homepage.do";
        } catch (RollbackException e) {
            request.setAttribute("error", e.getMessage());
            return "error.jsp";
        }
    }
}

