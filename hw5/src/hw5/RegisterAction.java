package hw5;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.formbeanfactory.FormBeanFactory;
import org.genericdao.DuplicateKeyException;
import org.genericdao.RollbackException;

import hw5.dao.*;
import hw5.databean.*;
import hw5.formbean.*;

public class RegisterAction extends Action {
	
	private FormBeanFactory<RegisterForm> formBeanFactory = new FormBeanFactory<>(RegisterForm.class);

    private UserDAO userDAO;

    public RegisterAction(Model model) {
        userDAO = model.getUserDAO();
    }

    public String getName() {
        return "register.do";
    }

    public String performGet(HttpServletRequest request) {
        // If user is already logged in, redirect to homepage.do
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "homepage.do";
        }

        // Otherwise, just display the register page.
        request.setAttribute("form", new RegisterForm());
    try {
    		request.setAttribute("users", userDAO.getUser());
    		} catch (RollbackException e) {
    		}
        return "register.jsp";
    }

    public String performPost(HttpServletRequest request) {
        // If user is already logged in, redirect to homepage.do
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "homepage.do";
        }

try {
            RegisterForm form = formBeanFactory.create(request);
            request.setAttribute("form", form);
            request.setAttribute("users", userDAO.getUser());
            // Any validation errors?
            if (form.hasValidationErrors()) {
                return "register.jsp";
            }
            
            try {
                User newUser = new User();
                newUser.setEmailAddress(form.getEmailAddress());
                newUser.setPassword(form.getPassword());
                newUser.setFirstName(form.getFirstName());
                newUser.setLastName(form.getLastName());
            			
                userDAO.create(newUser);
                session.setAttribute("user", newUser);
                return ("homepage.do");
                
                } catch (DuplicateKeyException e) {
                    form.addFieldError("emailAddress", "A user with this email already exists");
                    return "login.jsp";
                }
    
        } catch (RollbackException e) {
            request.setAttribute("error", e.getMessage());
            return "error.jsp";
        }
    }
}
