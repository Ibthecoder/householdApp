package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import DatabaseConnection.MyDatabaseConnection;
import java.sql.*;
import java.io.PrintWriter;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    try {
	    	Connection conn = DatabaseConnection.MyDatabaseConnection.getConnection();
	    	String sqlQuery = "SELECT * FROM Register WHERE email = ? AND password = ? ";
	    	PreparedStatement statement = conn.prepareStatement(sqlQuery);
	    	statement.setString(1, email);
	    	statement.setString(2, password);
	    	
	    	ResultSet result = statement.executeQuery();
	    	
	    	if(result.next()) {
	    		// Successful login
	    		HttpSession session = request.getSession();
	    		session.setAttribute("username", result.getString("UserName"));
	    		response.sendRedirect("dashbord.jsp");
	    	} else {
	    		// failed login:
	    		request.setAttribute("error", "Invalid email or password");
	    		request.getRequestDispatcher("login.jsp").forward(request, response);
	    	}
	    	
	    	conn.close();
	    
	    } catch(Exception e) {
	    	 out.println("<p>Error: " + e.getMessage() + "</p>");
	    }
	}

}
