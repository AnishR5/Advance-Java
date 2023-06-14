package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDaoimpl;

/**
 * Servlet implementation class registrationServlet
 */
@WebServlet("/registration")
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoimpl daobj;

	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			daobj=new UserDaoimpl();
			
		}catch(Exception e) {
			throw new ServletException("err in do-get " + getClass(), e);			
		}
	}

	
	public void destroy() {
		try {
			daobj.cleanUp();
		}catch(Exception e) {
			System.out.println("Error in cleanup");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter pw=response.getWriter()){
			String firstname=request.getParameter("fname");
			String LastName=request.getParameter("lname");
			String email=request.getParameter("email");
			String password=request.getParameter("pass");
			String dob=request.getParameter("dob");
			String status=daobj.registeruser(firstname, LastName, email, password, dob);
			if(status.equals("success")) {
				response.sendRedirect("login.html");
			}else {
				pw.print("<h2>Registration unsuccessfull</h2>");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException("err in do-get " + getClass(), e);
		}
	}

}
