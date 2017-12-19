package hw5.databean;

import org.formbeanfactory.InputType;
import org.genericdao.PrimaryKey;
import java.time.*;
import java.util.Date;

@PrimaryKey("postId")
public class Post {

		private int    postId;
		private String postText;
		private String emailAddress;
		private Date postTime;
		
		public String getEmailAddress() {
			return emailAddress;
		}
		@InputType("hidden")
		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}
		public Date getPostTime() {
			return postTime;
		}
		public void setPostTime(Date postTime) {
			this.postTime = postTime;
		}
		
		
		public int    getPostId()                { return postId;           }
	    public String getPostText()              { return postText;         }


	    public void   setPostId(int i)           { postId = i;              }
		
	    public void   setPostText(String s)      { postText = s;            }	

	
}
