package hw5.databean;

import org.formbeanfactory.InputType;
import org.genericdao.PrimaryKey;
import java.time.*;
import java.util.Date;

@PrimaryKey("commentId")
public class Comment {

	private int    commentId;
	private int 		postId;
	private String commentText;
	private String	emailAddress;
	private Date commentTime;
	private String author;
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCommentId() {
		return commentId;
	}
	
	@InputType("hidden")
	public void setCommentId(int c) {
		commentId = c;
	}
	public int getPostId() {
		return postId;
	}
	@InputType("hidden")
	public void setPostId(int d) {
		postId = d;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public  Date getCommentTime() {
		return commentTime;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String s) {
		commentText = s;
	}		
}

