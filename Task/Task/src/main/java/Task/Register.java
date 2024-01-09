package Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBConnection.connection;


@WebServlet("/Register")
public class Register extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String Name=request.getParameter("name");
		String Age=request.getParameter("age");
		String Phone=request.getParameter("phone");
		String MailId=request.getParameter("mail");
		String Location=request.getParameter("location");
		String Password=request.getParameter("password");
		String RePassword=request.getParameter("Rpassword");
		
		try 
		{
			Connection con=connection.connect();
			PreparedStatement st=con.prepareStatement("insert into Users(UserName,Age,Phone,MailId,Location,Password) values(?,?,?,?,?,?)");
			st.setString(1, Name);
			st.setString(2, Age);
			st.setString(3, Phone);
			st.setString(4, MailId);
			st.setString(5, Location);
			st.setString(6, Password);
			
			int rs=st.executeUpdate();
			
			if(Password.equals(RePassword)) {
				if(rs>0) 
					{
						out.print("<script>alert('Registration Completed...! ThankYou...!')</script>");
						
						RequestDispatcher R=request.getRequestDispatcher("Index.jsp");
						R.include(request, response);
					}
			}
			else {
				
				out.print("<script>alert('Check Your Details...!')</script>");
		
			}
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}
