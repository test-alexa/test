package hw4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.RollbackException;

import hw4.dao.UserDAO;
import hw4.databean.*;
import hw4.formbean.*;

@WebServlet("/Home")
public class Home extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserDAO userDAO;

	public void init() throws ServletException {
		ServletContext context = getServletContext();
		String jdbcDriverName = context.getInitParameter("jdbcDriverName");
		String jdbcURL = context.getInitParameter("jdbcURL");
		try {
			ConnectionPool cp = new ConnectionPool(jdbcDriverName, jdbcURL);

			cp.setDebugOutput(System.out); // Print out the generated SQL

			userDAO = new UserDAO(cp, "user");

		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("Login");
            return;
        }

        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);

        try {
            // Fetch the items now, so that in case this is a GET Request or if there
            // are errors, we can just dispatch to the JSP to show the item list
            // (and any errors)

            LoginForm loginForm = new LoginForm(request);
            
            request.setAttribute("loginForm", loginForm);
            System.out.println("before get");

            if ("GET".equals(request.getMethod())) {
                RequestDispatcher d = request.getRequestDispatcher("home.jsp");
                d.forward(request, response);
                return;
            }

            System.out.println("after get");
            errors.addAll(loginForm.getValidationErrors());
            if (errors.size() > 0) {
                RequestDispatcher d = request.getRequestDispatcher("home.jsp");
                d.forward(request, response);
                return;
            }
            
            // get all users from mysql
            User[] users = userDAO.match();
            // add this attribute, so that home.jsp can get those data
            request.setAttribute("users", users);


            RequestDispatcher d = request.getRequestDispatcher("home.jsp");
            d.forward(request, response);
            
        } catch (RollbackException e) {
            errors.add(e.getMessage());
            RequestDispatcher d = request.getRequestDispatcher("error.jsp");
            d.forward(request, response);
        }
    }
}
