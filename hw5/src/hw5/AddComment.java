package hw5;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.formbeanfactory.FormBeanFactory;
import org.genericdao.RollbackException;

import hw5.dao.*;
import hw5.databean.*;
import hw5.formbean.*;

public class AddComment extends Action{

	private PostDAO postDAO;
    private CommentDAO commentDAO;

    
    public AddComment(Model model) {
        commentDAO = model.getCommentDAO();
        postDAO = model.getPostDAO();

    }
	
    public String getName() {
        return "addComment.do";
    }

    public String performPost(HttpServletRequest request) {
    	
    	HttpSession session = request.getSession(true);
    	User user = (User) session.getAttribute("user");
    	
    	
    	if (user == null) {
    		return "login.do";
    	} 	try {	
    		
    		String content = (String) request.getParameter("content");
    		String email =  request.getParameter("email");
    		String postId = request.getParameter("postId");
    		System.out.println("from AddComment, input content is: "+content);
    			
    		if(content == null) {
        			System.out.println("content is null");
        			return "error.jsp";
        		}
        		
            Comment bean = new Comment();
            String a = user.getFirstName() + " " + user.getLastName();
            bean.setCommentText(content);
            bean.setEmailAddress(user.getEmailAddress());
            bean.setCommentTime(new Date(System.currentTimeMillis()));
            System.out.println("The comment is just made to the post with ID: "+request.getParameter("postId"));
            bean.setPostId(Integer.parseInt(request.getParameter("postId")));
            bean.setAuthor(a);
            request.setAttribute("postId", postId);
            request.setAttribute("email", email);
            	commentDAO.create(bean);
            	
            return "visitorpage.do?email="+email;

        } catch (RollbackException e) {
        	System.out.println("roll back exception");
            request.setAttribute("error",e.getMessage());
            return "error.jsp";
        }
    }
    
        
}
