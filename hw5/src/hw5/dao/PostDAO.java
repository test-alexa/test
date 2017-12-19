package hw5.dao;

import java.util.Arrays;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import hw5.databean.*;

public class PostDAO extends GenericDAO<Post>  {

	public PostDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(Post.class, tableName, cp);
	}

	public void addToTop(Post p) throws RollbackException {
		try {
			Transaction.begin();

			create(p);

			Transaction.commit();
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}
	}

	public Post[] getPosts(String emailAddress) throws RollbackException {


		Post[] posts = match(MatchArg.equals("emailAddress", emailAddress));
		
		//Arrays.sort(posts, (Post i1, Post i2) -> i1.timeToHash() - i2.timeToHash());
		//Arrays.sort(posts);
		return posts;
	}
	
	public Post[] getPost() throws RollbackException{
		Post[] posts = match();
		return posts;
	}
}


