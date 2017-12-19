package hw5;

import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.formbeanfactory.FormBeanFactory;
import org.genericdao.RollbackException;

import hw5.dao.*;
import hw5.databean.*;
import hw5.formbean.*;

public class AddPost extends Action {
   
    private PostDAO postDAO;
    private CommentDAO commentDAO;
    
    public AddPost(Model model) {
        postDAO = model.getPostDAO();
        commentDAO = model.getCommentDAO();
    }
	
    public String getName() {
        return "addPost.do";
    }

    public String performPost(HttpServletRequest request) {
    		User user = (User)request.getSession().getAttribute("user");
    		if(user == null)
    			return "login.do";
        
        try {
        		String content = request.getParameter("content");
        		if(content == null) {
        			//set some error attribute
        			return "error.jsp";
        		}
        		
            Post bean = new Post();
            bean.setPostText(content);
            bean.setEmailAddress(user.getEmailAddress());
            bean.setPostTime(new Date(System.currentTimeMillis()));
            
            postDAO.create(bean);
            
            //request.setAttribute("", arg1);
            
            return "homepage.do";

        } catch (RollbackException e) {
            request.setAttribute("error",e.getMessage());
            return "error.jsp";
        }
    }



}
