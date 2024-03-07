package Demo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListenServlet
 */
@WebServlet("/ListenServlet")
public class ListenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pr=response.getWriter();
		pr.print("Hello...,welcome to the ListenServlet");
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("username");
		String password=(String)session.getAttribute("password");
		
		
		pr.println("username from session:\n"+name);
		pr.println("password from session:\n"+password);
	}

}
