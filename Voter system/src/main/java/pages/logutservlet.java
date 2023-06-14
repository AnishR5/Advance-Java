package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CandidateDao;
import Dao.CandidateDaoimpl;
import Dao.UserDaoimpl;
import Pojo.User;


@WebServlet("/logout")
public class logutservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter pw=response.getWriter())
		{
			HttpSession session=request.getSession();
			User voter= (User) session.getAttribute("user_details");
			pw.print("<h4> Hello "+voter.getFirstname()+" "+voter.getLastname()+"</h4>");
			if(voter!=null) {
				if(voter.getVotingstatus()) {
					pw.print("<h4>You have already voted. Thank you Voting</h4>");
				}
				else {
					int candidateId=Integer.parseInt(request.getParameter("cid"));
					CandidateDaoimpl cdao= (CandidateDaoimpl) session.getAttribute("candidate_dao");
					UserDaoimpl udao=(UserDaoimpl) session.getAttribute("user_dao");
					udao.updateVotingStatus(voter.getId());
					String status=cdao.incrementCandidateVotes(candidateId);
					
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
