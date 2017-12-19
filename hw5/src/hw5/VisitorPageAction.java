package hw5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.*;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import hw5.dao.*;
import hw5.databean.*;
import hw5.formbean.*;

public class VisitorPageAction extends Action {
	private PostDAO postDAO;
	private CommentDAO commentDAO;
	private UserDAO userDAO;
//	private Post[] listOfPosts;
//	private Comment[] listOfComments;


	
	public VisitorPageAction(Model model) {
		postDAO = model.getPostDAO();
		commentDAO = model.getCommentDAO();
		userDAO = model.getUserDAO();
	}
	
	public String getName() {
		return "visitorpage.do";
	}
	
	public String performGet(HttpServletRequest request) {
		return performPost(request);
	}
	public String performPost(HttpServletRequest request) {
    try {
      
    		HttpSession session = request.getSession(true);
    		User user = (User) session.getAttribute("user");
    		String gotEmail = request.getParameter("email");
    		System.out.println("From VisitorPageAction, the email address related to the post is " + gotEmail);
    		if (user == null) {
        		
    			//String fullName = u.getFirstName() + " " + user.getLastName();
        		
          		 ArrayList<Comment[]> commentss = new ArrayList<Comment[]>();
          		 Post[] postss = postDAO.getPosts(gotEmail);
          		 
          		 for(int i = 0; i < commentss.size(); i++ ) {
          			 commentss.add(commentDAO.getComments(postss[i].getPostId()));
          		 }	
               	
          		 request.setAttribute("users", userDAO.getUser());
               request.setAttribute("posts", postss);
               request.setAttribute("comments", commentss);
               //session.setAttribute("name", fullName);
    			return ("visitor.jsp");
    		}
    		String fullName = user.getFirstName() + " " + user.getLastName();
    		
   		 ArrayList<Comment[]> commentss = new ArrayList<Comment[]>();
   		 Post[] postss = postDAO.getPosts(gotEmail);
   		 System.out.println("From VisitorPageAction, the length of the posts Array is " +postss.length);
   		 System.out.println("getting the total number of rolls in commentDAO: " + commentDAO.getCount());
   		 for(int i = 0; i < postss.length; i++ ) {
   			 
   			 commentss.add(commentDAO.getComments(postss[i].getPostId()));
   		 }	
        	
 		request.setAttribute("users", userDAO.getUser());
        request.setAttribute("posts", postss);
        request.setAttribute("comments", commentss);
        session.setAttribute("name", fullName);
        System.out.println("Printing the returned comments: ");
        for (int i = 0; i < postss.length; i++) {
        	Comment[] c = commentss.get(i);
        	for(int j = 0; j < c.length; j++) {
        		System.out.println(c[j]);
        	}
        }
        //System.out.println("");
            return ("visitor.jsp");
        } catch (RollbackException e) {
            request.setAttribute("error",e.getMessage());
            return "error.jsp";
        }
	}
	
}
