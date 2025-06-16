<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*, jakarta.servlet.http.*" %>
<%@ page import="entity.BudgetEntry" %>
<%
List<BudgetEntry> entries = (List<BudgetEntry>) request.getAttribute("entries");
%>
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<%
BudgetEntry entry = (BudgetEntry) request.getAttribute("entry");
String formAction = (entry != null) ? "UpdateBudgetServlet" : "AddBudgetServlet";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Budget Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 text-gray-800 font-sans">

    <!-- Navigation Bar -->
    <nav class="bg-blue-600 p-4 text-white flex justify-between items-center">
        <h1 class="text-2xl font-bold">Hello, <%= username %> 👋</h1>
        <a href="index.jsp" class="bg-red-500 px-4 py-2 rounded hover:bg-red-700">Logout</a>
    </nav>

    <!-- Main Dashboard Section -->
    <div class="max-w-6xl mx-auto mt-8 p-6 bg-white shadow rounded-lg">

        <!-- Filters -->
        <div class="mb-6">
            <form method="get" action="FilterServlet" class="flex gap-4 flex-wrap">
                <input type="date" name="startDate" class="border rounded px-4 py-2" required>
                <input type="date" name="endDate" class="border rounded px-4 py-2" required>
                <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-800">Filter</button>
            </form>
        </div>

        <!-- Add/Update Entry Form -->
        <div class="mb-8">
            <h2 class="text-xl font-bold mb-4"><%= (entry != null) ? "Update Entry" : "Add New Entry" %></h2>
            <form method="post" action="<%= formAction %>" class="grid grid-cols-1 md:grid-cols-5 gap-4">
                <% if (entry != null) { %>
                    <input type="hidden" name="entryId" value="<%= entry.getEntryId() %>">
                    <input type="hidden" name="userId" value="<%= entry.getUserId() %>">
                <% } %>
                <input type="date" name="date" value="<%= (entry != null) ? entry.getDate() : "" %>" class="border px-3 py-2 rounded" required>
                <input type="text" name="type" placeholder="Income / Expense / Recurring" value="<%= (entry != null) ? entry.getType() : "" %>" class="border px-3 py-2 rounded" required>
                <input type="number" name="amount" placeholder="Amount" value="<%= (entry != null) ? entry.getAmount() : "" %>" class="border px-3 py-2 rounded" required>
                <input type="text" name="description" placeholder="Description" value="<%= (entry != null) ? entry.getDescription() : "" %>" class="border px-3 py-2 rounded">
                <button type="submit" class="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-800">
                    <%= (entry != null) ? "Update" : "Add" %>
                </button>
            </form>
        </div>

        <!-- Budget Table -->
        <div>
            <h2 class="text-xl font-bold mb-4">Budget History</h2>
            <table class="min-w-full bg-white border">
                <thead class="bg-gray-200 text-gray-700">
                    <tr>
                        <th class="px-4 py-2 border">Date</th>
                        <th class="px-4 py-2 border">Type</th>
                        <th class="px-4 py-2 border">Amount</th>
                        <th class="px-4 py-2 border">Description</th>
                        <th class="px-4 py-2 border">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (entries != null && !entries.isEmpty()) {
                        for (BudgetEntry be : entries) { %>
                            <tr class="text-center">
                                <td class="px-4 py-2 border"><%= be.getDate() %></td>
                                <td class="px-4 py-2 border"><%= be.getType() %></td>
                                <td class="px-4 py-2 border"><%= be.getAmount() %></td>
                                <td class="px-4 py-2 border"><%= be.getDescription() %></td>
                                <td class="px-4 py-2 border">
                                    <a href="EditBudgetServlet?id=<%= be.getEntryId() %>" class="text-blue-600 hover:underline">Edit</a> |
                                    <a href="DeleteBudgetServlet?id=<%= be.getEntryId() %>" class="text-red-600 hover:underline">Delete</a>
                                </td>
                            </tr>
                    <%  }
                    } else { %>
                        <tr>
                            <td colspan="5" class="text-center py-4">No budget entries found.</td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>
