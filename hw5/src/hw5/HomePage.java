package hw5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.*;

import org.genericdao.RollbackException;

import hw5.dao.*;
import hw5.databean.*;
import hw5.formbean.*;

public class HomePage extends Action {
	private PostDAO postDAO;
	private CommentDAO commentDAO;
	private UserDAO userDAO;
	
	public HomePage(Model model) {
		postDAO = model.getPostDAO();
		commentDAO = model.getCommentDAO();
		userDAO = model.getUserDAO();

	}
	
	public String getName() {
		return "homepage.do";
	}
	
	public String performGet(HttpServletRequest request) {
		return performPost(request);
	}
	public String performPost(HttpServletRequest request) {
        try {
        		HttpSession session = request.getSession(true);
        		User user = (User) session.getAttribute("user");
        		String fullName = user.getFirstName() + " " + user.getLastName();
        		

        		 ArrayList<Comment[]> commentss = new ArrayList<Comment[]>();
        		 Post[] postss = postDAO.getPosts(user.getEmailAddress());
        		 
        		 for(int i = 0; i < postss.length; i++ ) {
        			 commentss.add(commentDAO.getComments(postss[i].getPostId()));
        			
        		 }
        	
        		request.setAttribute("users", userDAO.getUser());
            request.setAttribute("posts", postss);
            request.setAttribute("comments", commentss);
            session.setAttribute("name", fullName);
            
            return ("home.jsp");
        } catch (RollbackException e) {
            request.setAttribute("error",e.getMessage());
            return "error.jsp";
        }
	}
}
