package hw5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;

import hw5.dao.*;
import hw5.databean.*;
import hw5.formbean.*;

public class LogoutAction extends Action {
		
    public LogoutAction(Model model) {
    }

    public String getName() {
        return "logout.do";
    }

    public String performPost(HttpServletRequest request) {
    		return performGet(request);
//        HttpSession session = request.getSession();
//        session.setAttribute("user", null);
//        request.setAttribute("form", new LoginForm());
//        try{
//        	request.setAttribute("users", userDAO.getUser());
//        } catch (RollbackException e) {
//        	
//        }
//        return "login.jsp";
    }
    
    public String performGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("user", null);
        
        return "login.do";
    }
}
