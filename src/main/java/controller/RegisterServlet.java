package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//
		try {
			// let connect to the dataBase:
			Connection conn = DatabaseConnection.MyDatabaseConnection.getConnection();
			String sqlQuery ="INSERT INTO Register (UserName , email ,password) VALUE (? , ? , ?)";
			PreparedStatement statement = conn.prepareStatement(sqlQuery);
			statement.setString(1, username);
			statement.setString(2,email);
			statement.setString(3, password);
			
			int result = statement.executeUpdate();
			
			if(result > 0 ) {
				response.getWriter().println("Registration successful!");
			} else {
				response.getWriter().println("Registration failed!");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			response.getWriter().println("Error: " + e.getMessage());
			
		}
		
		
	}

}
