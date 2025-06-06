package DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MyDatabaseConnection {
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		// define field for the connection
		String url = "jdbc:mysql://localhost:3306/BudgetApp_directory";
		String user = "root";
		String password = "Pemisire8@";
		
		// Load the MySQL JDBC driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Establish and return the connection:
		
		return DriverManager.getConnection(url,user,password);
				
	}

}
