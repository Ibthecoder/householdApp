package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.BudgetEntryDAO;
import entity.BudgetEntry;

/**
 * Servlet implementation class EditBudgetServlet
 */
@WebServlet("/EditBudgetServlet")
public class EditBudgetServlet extends HttpServlet {
	  private static final long serialVersionUID = 1L;

	    private BudgetEntryDAO budgetDAO;

	    @Override
	    public void init() throws ServletException {
	        budgetDAO = new BudgetEntryDAO();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        try {
	            long entryId = Long.parseLong(request.getParameter("id"));

	            BudgetEntry entry = budgetDAO.getEntryById(entryId);

	            if (entry != null) {
	                // Add the entry to the request so the form can populate it
	                request.setAttribute("entry", entry);

	                // Optional: preload all entries again for display in table
	                request.setAttribute("entries", budgetDAO.getAllEntriesByUserId(entry.getUserId()));

	                // Forward to dashboard.jsp
	                RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
	                dispatcher.forward(request, response);
	            } else {
	                response.sendRedirect("dashboard.jsp");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("dashboard.jsp");
	        }
	    }
       
    

}
