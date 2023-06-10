package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import Dao.UserDaoimpl;
import Pojo.User;


@WebServlet("/login")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoimpl daobject;
	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			daobject= new UserDaoimpl();
		}catch(Exception e) {
			throw new ServletException();
		}
		
	}

	
	public void destroy() {
		try {
			daobject.cleanUp();
		}
		catch(Exception e) {
			System.out.println("error in destroy method");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter pw=response.getWriter())
		{
			String email=request.getParameter("em");
			String password=request.getParameter("pass");
			User user=daobject.authenticateUser(email, password);
			if(user==null) {
				pw.print("<h3>Invalid email and password</h3>");
			}
			else {
				pw.print("<h3>Valid user: "+user+"</h3>");
				
				if(user.getRole().equals("admin")) {
					
					response.sendRedirect("admin_page");
				}
				else {
					if(user.getVotingstatus()) {
						response.sendRedirect("logout");	
					}
					else {
						response.sendRedirect("candidate_page");
					}
					
				}
			}
			
		}catch(Exception e) {
			throw new ServletException();
		}
		
	}

}
