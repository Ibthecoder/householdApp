package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import dao.BudgetEntryDAO;
import entity.BudgetEntry;

/**
 * Servlet implementation class DashboardServlet
 */@WebServlet("/DashboardServlet")
 public class DashboardServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(false);
			Long userId = (Long) session.getAttribute("userId");

			if (userId == null) {
				response.sendRedirect("index.jsp");
				return;
			}

			BudgetEntryDAO dao = new BudgetEntryDAO();
			List<BudgetEntry> entries = dao.getEntriesByUserId(userId); // ✅ corrected here

			request.setAttribute("entries", entries);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
	}

