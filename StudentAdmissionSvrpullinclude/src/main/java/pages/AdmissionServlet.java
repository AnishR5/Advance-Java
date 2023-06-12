package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Pojo.Student;


@WebServlet("/result")
public class AdmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
			Student student=(Student) request.getAttribute("student_dtls");
			if(student.isAdmitted()) {
				System.out.println("in admission servlet");
				pw.print("<h5>Hello "+student.getFname()+" "+student.getLname()+"</h5>");
				pw.print("<h5>Congratulations You have been admitted to Iacsd"+"</h5>");
			}
			else {
				System.out.println("in admission servlet");
				pw.print("<h5>Hello "+student.getFname()+" "+student.getLname()+"</h5>");
				pw.print("<h5>Unfortunately You have not been admitted to Iacsd"+"</h5>");
			}
				
			
		
	}

}
