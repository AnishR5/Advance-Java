package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Pojo.Courses;
import Pojo.Student;


@WebServlet("/process_form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(PrintWriter pw=response.getWriter())
		{
			String fname=request.getParameter("fn");
			String lname=request.getParameter("ln");
			int marks =Integer.parseInt(request.getParameter("score")) ;
			Courses course=Courses.valueOf(request.getParameter("course").toUpperCase()) ;
			Student student=new Student(fname, lname, marks, course, false);
			
			if(marks>course.getMinscore()) {
				student.setAdmitted(true);
			}
			
			request.setAttribute("student_dtls", student);
			
			RequestDispatcher rd= request.getRequestDispatcher("result");
			rd.forward(request, response);
			
			
			
		}catch(Exception e) {
			throw new ServletException();
		}
		
	}

}
