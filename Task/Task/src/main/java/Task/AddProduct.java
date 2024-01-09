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


@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet
{
	private static final long serialVersionUID = 1L;
           
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String PDName=request.getParameter("PDname");
		String PDPrice=request.getParameter("PDprice");
		String PDId=request.getParameter("PDid");
		
		try 
		{
			Connection con=connection.connect();
			PreparedStatement ps=con.prepareStatement("insert into Products(ProductName,ProductPrice,ProductId) values(?,?,?)");
			ps.setString(1, PDName);
			ps.setString(2, PDPrice);
			ps.setString(3, PDId);
			
			int rs=ps.executeUpdate();
			
			if(rs>0) {
				out.print("<script>alert('Product Added Successfully')</script>");
				RequestDispatcher r=request.getRequestDispatcher("Admin");
				r.include(request, response);
			}
			else {
				out.print("<script>alert('Check Your Credientials..!')</script>");
			}
			
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
