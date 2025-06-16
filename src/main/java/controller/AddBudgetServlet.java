package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

import dao.BudgetEntryDAO;
import entity.BudgetEntry;

/**
 * Servlet implementation class AddBudgetServlet
 */
@WebServlet("/AddBudgetServlet")
public class AddBudgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            String type = request.getParameter("type");
            String description = request.getParameter("description");
            double amount = Double.parseDouble(request.getParameter("amount"));
            LocalDate date = LocalDate.parse(request.getParameter("date"));

            BudgetEntry entry = new BudgetEntry();
            entry.setUserId(userId);
            entry.setType(type);
            entry.setDescription(description);
            entry.setAmount(amount);
            entry.setDate(date);

            BudgetEntryDAO dao = new BudgetEntryDAO();
            boolean success = dao.addEntry(entry);

            if (success) {
                response.sendRedirect("DashboardServlet"); // refresh dashboard
            } else {
                request.setAttribute("error", "Failed to add entry.");
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Invalid input.");
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }
        
        
    }
    
    
		

}
