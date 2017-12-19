package hw5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.formbeanfactory.FormBeanFactory;
import org.genericdao.RollbackException;

import hw5.dao.*;
import hw5.databean.*;
import hw5.formbean.*;

public class DeletePost extends Action{
	
	private PostDAO postDAO;
	
	public DeletePost(Model model) {
        postDAO = model.getPostDAO();
    }

    public String getName() {
        return "deletePost.do";
    }

    public String performPost(HttpServletRequest request) {
    
    HttpSession session = request.getSession(true);
    	User user = (User) session.getAttribute("user");

    	if (user == null) {
    		return "login.do";
    	}

    	
   	 try {
        	String string_id = request.getParameter("postId");
        	int id = 0;
        	try{
        		id = Integer.parseInt(string_id);
        	} catch(NumberFormatException e){
        		return "error.jsp";
        	}
        	
            postDAO.delete(id);
            return "homepage.do";

        } catch (RollbackException e) {
            request.setAttribute("error", e.getMessage());
            return "error.jsp";
        }
    }
}


