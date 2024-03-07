package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Databaseservlet
 */
@WebServlet("/Databaseservlet")
public class Databaseservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pr=response.getWriter();
		String user = request.getParameter("fname");
		int uid = Integer.parseInt(request.getParameter("uid"));
		String last = request.getParameter("lname");
		String address = request.getParameter("add");
		String city = request.getParameter("city");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String username = "system";
			String password = "Welcome$06";

			Connection con = DriverManager.getConnection(url, username, password);
			//Connection con1 = DatabaseConnection.initializeDatabase(); 
			System.out.println("connected..........sucessfully");
			PreparedStatement ps = con.prepareStatement("insert into Persons values(?,?,?,?,?)");
			
			ps.setInt(1, uid);
			ps.setString(2, last);
			ps.setString(3, user);
			ps.setString(4, address);
			ps.setString(5, city);
			ResultSet Rs = ps.executeQuery();
			System.out.println("query excuted..........sucessfully");

//			while (Rs.next()) {
//				String Name = Rs.getString("firstname");
//				int Personid = Rs.getInt("Personid");
//				String lName = Rs.getString("firstname");
//				int Personid = Rs.getInt("Personid");
//				System.out.println(Name + "     " + Personid);
//			}
			con.close();

		} catch (SQLException e) {
			System.out.println("Error:"+e);
		}
pr.print("Successfully executed");
	}
}