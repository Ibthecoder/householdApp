package DatabaseConnection;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/test-db")
public class TestDBServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    
    try {
      Connection conn = MyDatabaseConnection.getConnection();
      response.getWriter().println("Connected to database successfully!");
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
      response.getWriter().println("Failed to connect to database: " + e.getMessage());
    }
  }
}
