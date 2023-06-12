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
import javax.servlet.http.HttpSession;

import Dao.CandidateDaoimpl;
import Dao.UserDao;
import Dao.UserDaoimpl;
import Pojo.User;


@WebServlet(value="/login", loadOnStartup = 1)
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoimpl userdaobject;
	private CandidateDaoimpl  candidatedaobject;
	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			userdaobject= new UserDaoimpl();
			candidatedaobject=new CandidateDaoimpl();
		}catch(Exception e) {
			throw new ServletException("err in init of " + getClass(), e);
		}
		
	}

	
	public void destroy() {
		try {
			userdaobject.cleanUp();
			candidatedaobject.cleanUp();
		}
		catch(Exception e) {
			System.out.println("error in destroy method"+ getClass()+" "+ e);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter pw=response.getWriter())
		{
			String email=request.getParameter("em");
			String password=request.getParameter("pass");
			User user=userdaobject.authenticateUser(email, password);
			if(user==null) {
				pw.print("<h3>Invalid email and password</h3>");
			}
			else {
				HttpSession hs=request.getSession();
				hs.setAttribute("user_details", user);
				hs.setAttribute("user_dao", userdaobject);
				hs.setAttribute("candidate_dao", candidatedaobject);
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
			throw new ServletException("err in init of " + getClass(), e);
		}
		
	}

}
