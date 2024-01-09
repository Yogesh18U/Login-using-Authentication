package Task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LogOut")
public class LogOut extends HttpServlet
{
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		Cookie A=new Cookie("ProductName","");
		A.setMaxAge(0);
		response.addCookie(A);
		
		out.print("<script>alert('LogOut Successful')</script>");
		
		RequestDispatcher r=request.getRequestDispatcher("Index.jsp");
		r.include(request, response);
	}

}
