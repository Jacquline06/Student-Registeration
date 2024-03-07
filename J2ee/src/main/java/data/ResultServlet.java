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
 * Servlet implementation class ResultServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pr = response.getWriter();
		String user = request.getParameter("fname");
		int uid = Integer.parseInt(request.getParameter("uid"));
		String last = request.getParameter("lname");
		String address = request.getParameter("add");
		String city = request.getParameter("city");

		try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}

		try {
		    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		    String username = "system";
		    String password = "Welcome$06";

		    Connection con = DriverManager.getConnection(url, username, password);
	pr.println("Connected successfully");

		    // Check if a record with the given name already exists
		    PreparedStatement checkName = con.prepareStatement("SELECT COUNT(*) FROM Persons WHERE FIRSTNAME = ?");
		    checkName.setString(1, user);
		    ResultSet resultSet = checkName.executeQuery();
		    resultSet.next();
		    int count = resultSet.getInt(1);

		    if (count == 0) {
		        pr.println("No records found with the given name.");
		       
		    } else if(count>0) {
		    	pr.println(" records found with the given name....please enter different name");
		    }
//		    else if(count!=0){
//		        // No record found, print the message
//		        pr.println("Data inserting................");
//
//		        // Optionally, proceed with the insert operation if desired
//		        PreparedStatement ps = con.prepareStatement("INSERT INTO Persons VALUES (?, ?, ?, ?, ?)");
//
//		        ps.setInt(1, uid);
//		        ps.setString(2, last);
//		        ps.setString(3, user);
//		        ps.setString(4, address);
//		        ps.setString(5, city);
//
//		        int rowsAffected = ps.executeUpdate();
//
//		        if (rowsAffected > 0) {
//		            pr.println("Data inserted successfully");
//		        } else {
//		            pr.println("Failed to insert data");
//		        }

		      //  ps.close();
		        resultSet.close();
		        con.close();
		    //}

		} catch (SQLException e) {
		    pr.println("Error: " + e);
		} 

	}
}

