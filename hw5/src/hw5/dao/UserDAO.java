package hw5.dao;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.RollbackException;

import hw5.databean.Post;
import hw5.databean.User;

public class UserDAO extends GenericDAO<User> {
    public UserDAO(ConnectionPool cp, String tableName) throws DAOException {
        super(User.class, tableName, cp);
    }
    
	public User[] getUser() throws RollbackException{
		User[] users = match();
		return users;
	}
}
