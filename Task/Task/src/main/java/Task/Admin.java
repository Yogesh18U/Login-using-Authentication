package Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBConnection.connection;


@WebServlet("/Admin")
public class Admin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
			PrintWriter out=response.getWriter();
		
		try {
			Connection con=connection.connect();
			Statement st=con.createStatement();
			String query="select * from Products";
			ResultSet rs=st.executeQuery(query);
			
			out.print("<table border=1>");
			out.print("<tr><td>Product Name</td><td>Product Price</td><td>Product Id</td><td>Delete Product</td><td>Update Product</td></tr>");
			
			while(rs.next()) {
				out.print("<tr><td>"+rs.getString("ProductName")+"</td><td>"+rs.getString("ProductPrice")+
						"</td><td>"+rs.getString("ProductId")+
						"</td><td><a href='DeleteProduct?Pname="+rs.getString("ProductName")+"'>Delete</a>"+
						"</td><td><a href='UpdateProduct?Pname="+rs.getString("ProductName")+"'>Update</a></tr>");
			}
			
			out.print("</table><br>");
			
			
			out.print("<a href='AddProduct.jsp'><button>Add Product</button></a> <br><br>");
			
			out.print("<a href='LogOut'><button>LogOut</button></a>");
			
		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
		}
		
		
	}

}
