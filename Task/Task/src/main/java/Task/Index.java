package Task;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBConnection.connection;


@WebServlet("/Index")
public class Index extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String Name=request.getParameter("name");
		String Pass=request.getParameter("pass");
		
		try 
		{
			Connection con=connection.connect();
			PreparedStatement ps=con.prepareStatement("Select * from Users where UserName=?and Password=?");
			ps.setString(1, Name);
			ps.setString(2, Pass);
			ResultSet Rs=ps.executeQuery();
			
			if(Rs.next()) {
				out.print("<script>alert('LogIn Successfully')</script>");
				RequestDispatcher r=request.getRequestDispatcher("Home");r.include(request, response);
			}
			
			else if(Name.equals("Admin")&&Pass.equals("1000")) {
				
				out.print("<script>alert('LogIn Successfully')</script>");
				
				RequestDispatcher r=request.getRequestDispatcher("Admin");r.include(request, response);
			}
			
			else {
				out.print("<script>alert('Check Your UserName and Password')</script>");
				RequestDispatcher r=request.getRequestDispatcher("Index.jsp");r.include(request, response);
			}
		} 
				
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
