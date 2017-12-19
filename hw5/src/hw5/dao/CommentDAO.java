package hw5.dao;

import java.util.Arrays;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import hw5.databean.*;

public class CommentDAO extends GenericDAO<Comment> {

	public CommentDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(Comment.class, tableName, cp);
	}

	public void addToTop(Comment p) throws RollbackException {
		try {
			Transaction.begin();
			create(p);

			Transaction.commit();
			
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}
	}
	
	public Comment[] getComments(int idOfPost) throws RollbackException {

		// Calls GenericDAO's match() method.
		// This no match constraint arguments, match returns all the Item beans
		Comment[] comments = match(MatchArg.equals("postId", idOfPost));
		
		//Arrays.sort(comments, (Comment i1, Comment i2) -> i1.timeToHash() - i2.timeToHash());

		return comments;
	}
	
	public Comment[] getComment() throws RollbackException {
		Comment[] comment = match();
		return comment;
	}
}
