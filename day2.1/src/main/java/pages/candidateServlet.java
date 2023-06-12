package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CandidateDaoimpl;
import Pojo.Candidate;
import Pojo.User;


@WebServlet("/candidate_page")
public class candidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter pw=response.getWriter())
		
		{
			HttpSession session=request.getSession();
			User userDetails=(User) session.getAttribute("user_details");
			if(userDetails!=null) {
				pw.print("<h2>Hello "+userDetails.getFirstname()+" "+userDetails.getLastname() + "</h2>");
				CandidateDaoimpl dao=(CandidateDaoimpl) session.getAttribute("candidate_dao");
				List<Candidate> candidatelist=dao.getAllCandidates();
				pw.print("<form action='logout'>");
				for(Candidate c: candidatelist) {
					pw.print("<input type='radio' name='cid' value='"+c.getId()+"'/>"+c.getName()+"<br>");
				}
				pw.print("<h5><input type='submit' value='Cast a vote'/></h5>");
				pw.print("</form>");
				
			}
			else {
				pw.print("<h5> Session Tracking Failed , No Cookies!!!!!!!!!!!!!</h5>");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
