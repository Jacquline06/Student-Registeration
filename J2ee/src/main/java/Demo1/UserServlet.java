package Demo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pr=response.getWriter();
		pr.print("Hello...,welcome to the UserServlet");
		String user=request.getParameter("uid");
		String upass=request.getParameter("pid");

		HttpSession session=request.getSession();
		session.setAttribute("username", user);
		session.setAttribute("password", upass);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dis=request.getRequestDispatcher("ListenServlet");
		dis.forward(request, response);
	}


}
