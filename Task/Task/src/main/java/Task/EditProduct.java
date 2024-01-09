package Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBConnection.connection;


@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
           
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String PDName=request.getParameter("ProductName");
		String UpdatePrice=request.getParameter("UpdatePrice");
		
	try {
		Connection con=connection.connect();
		Statement st=con.createStatement();
		String query= "update Products set ProductPrice='"+UpdatePrice+"' where ProductName='"+PDName+"'";
		int rs=st.executeUpdate(query);
		
		if(rs>0) 
		{
			out.print("<script>alert('Product Update Successfully')</script>");
			RequestDispatcher r=request.getRequestDispatcher("Admin");
			r.include(request, response);
			
		}
		
		
	} 
	catch (ClassNotFoundException | SQLException e) 
	{
		e.printStackTrace();
	}
	
	
	}

}
