package hw5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.formbeanfactory.FormBeanFactory;
import org.genericdao.RollbackException;

import hw5.dao.*;
import hw5.databean.*;
import hw5.formbean.*;

public class DeleteComment extends Action {

    private CommentDAO commentDAO;

    public DeleteComment(Model model) {
        commentDAO = model.getCommentDAO();
    }

    public String getName() {
        return "deleteComment.do";
    }

    public String performPost(HttpServletRequest request) {
   
    HttpSession session = request.getSession(true);
    	User user = (User) session.getAttribute("user");
    	if (user == null) {
    		return "login.do";
    	}
    	
    try {
    			String string_id = request.getParameter("CommentId");
    			System.out.println(string_id);
    			int id = 0;
    		
    try {
        		id = Integer.parseInt(string_id);
        
    } catch (NumberFormatException e) {
        		return "error.jsp";
        }
            commentDAO.delete(id);

            return "homepage.do";
            //return "visitorpage.do?"+email;
        } catch (RollbackException e) {
            request.setAttribute("error", e.getMessage());
            return "error.jsp";
        }
    }
}

