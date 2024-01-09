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


@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String PDName=request.getParameter("Pname");
		
		try 
		{
			Connection con=connection.connect();
			Statement st=con.createStatement();
			String query="Delete from Products where ProductName='"+PDName+"'";
			int rs=st.executeUpdate(query);
			
			if(rs>0) {
				out.print("<script>alert('Product Delete Successfully')</script>");
				RequestDispatcher r=request.getRequestDispatcher("Admin");
				r.include(request, response);
			}
			
			else {
				out.print("<script>alert('Product Not Deleted...!')</script>");
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
