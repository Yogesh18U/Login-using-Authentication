package Task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
          
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String PDName1=request.getParameter("Pname");
		String PDName=PDName1;
		
		out.print("<form action=EditProduct> UpdatePrice : <input type='text' name='UpdatePrice'>"+
				  "<br><br> ProductName : <input type='text' name='ProductName' value="+PDName+">"+
			      "<br><br> <input type='submit' value='Update'></form>");
		
	}

}
