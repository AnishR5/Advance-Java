package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//web container reads this only once at the web application deployment
//Wc creates an empty map and then populates url map
//key:/test1 value:pages.Servlet1

@WebServlet(value="/test1",loadOnStartup = 2 ) 
public class Servlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in doget by:"+ Thread.currentThread());
		//set resp content type==> text/html
		resp.setContentType("text/html");
		//get PW to send char, buf data to client
		
		try(PrintWriter pw=resp.getWriter())
		{
			pw.print("<h2> Welcome to servlet1: "+getClass()+"Ts"+LocalTime.now()+"</h2>");
		}//pw.close() -->pw.flush()-->buffer content flushed out -->resp renderded
	}

	@Override
	public void destroy() {
		System.out.println("in destroy by:"+ Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init by:"+ Thread.currentThread());
	}
	 

}
