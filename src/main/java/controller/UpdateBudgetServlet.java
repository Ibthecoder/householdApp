package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import dao.BudgetEntryDAO;
import entity.BudgetEntry;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateBudgetServlet")
public class UpdateBudgetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int entryId = Integer.parseInt(request.getParameter("entryId"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            String type = request.getParameter("type");
            String description = request.getParameter("description");
            double amount = Double.parseDouble(request.getParameter("amount"));
            String dateStr = request.getParameter("date");

            // ✅ Convert date string to LocalDate
            LocalDate date = LocalDate.parse(dateStr);

            // Create and populate updated BudgetEntry
            BudgetEntry updatedEntry = new BudgetEntry();
            updatedEntry.setEntryId(entryId);
            updatedEntry.setUserId(userId);
            updatedEntry.setType(type);
            updatedEntry.setDescription(description);
            updatedEntry.setAmount(amount);
            updatedEntry.setDate(date);

            // Update in database
            BudgetEntryDAO dao = new BudgetEntryDAO();
            boolean updated = dao.updateEntry(updatedEntry);

            if (updated) {
                // ✅ Reload updated list of entries for this user
                List<BudgetEntry> entries = dao.getEntriesByUserId(userId);
                request.setAttribute("entries", entries);

                // Forward to dashboard with updated list
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            } else {
                response.getWriter().println("Failed to update budget entry.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred while updating the entry.");
        }
    }
}

