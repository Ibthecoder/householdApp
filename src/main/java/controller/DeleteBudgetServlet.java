package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class DeleteBudgetServlet
 */
@WebServlet("/DeleteBudgetServlet")
public class DeleteBudgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		
		try {
			Connection conn = DatabaseConnection.MyDatabaseConnection.getConnection();
			PreparedStatement statement = conn.prepareStatement("DELETE FROM budget_entries WHERE entry_id = ?");
			statement.setLong(1, id);
			statement.executeUpdate();
			
			response.sendRedirect("DashboardServlet");
		} catch(Exception e) {
			e.printStackTrace();
			response.getWriter().println("Error deleting entry: " + e.getMessage());
		}
	}



}
