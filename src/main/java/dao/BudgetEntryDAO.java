package dao;

import java.sql.*;
import java.util.*;
import entity.BudgetEntry;
import java.sql.Date;



public class BudgetEntryDAO {
	
	 // 1. Add new entry
	public boolean addEntry(BudgetEntry entry) {
		
		String sqlQuery = "INSERT INTO budget_entries (user_id , entry_type , description, amount ,entry_date) VALUES(? , ? , ? , ? , ?)";
		
		try(Connection conn = DatabaseConnection.MyDatabaseConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(sqlQuery)) {
			
			statement.setLong(1, entry.getUserId());
			statement.setString(2, entry.getType());
			statement.setString(3, entry.getDescription());
			statement.setDouble(4, entry.getAmount());
			statement.setDate(5, Date.valueOf(entry.getDate()));
			
			return statement.executeUpdate() > 0;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	// 2. Get all entries for a user:
	public List<BudgetEntry> getEntriesByUserId(long userId) {
	    List<BudgetEntry> entries = new ArrayList<>();
	    String sql = "SELECT * FROM budget_entries WHERE user_id = ? ORDER BY entry_date DESC";

	    try (Connection conn = DatabaseConnection.MyDatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setLong(1, userId); // changed to setLong to match method signature
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            BudgetEntry entry = new BudgetEntry();
	            entry.setEntryId(rs.getInt("entry_id"));
	            entry.setUserId(rs.getInt("user_id"));
	            entry.setType(rs.getString("entry_type"));
	            entry.setAmount(rs.getDouble("amount"));

	            // ✅ Convert SQL date to LocalDate
	            java.sql.Date sqlDate = rs.getDate("entry_date");
	            if (sqlDate != null) {
	                entry.setDate(sqlDate.toLocalDate());
	            }

	            entry.setDescription(rs.getString("description"));
	            entries.add(entry);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return entries;
	}

	public boolean updateEntry(BudgetEntry entry) {
	    String sql = "UPDATE budget_entries SET entry_type = ?, description = ?, amount = ?, entry_date = ? WHERE entry_id = ? AND user_id = ?";
	    
	    
	    
	    
	    
	    try (Connection conn = DatabaseConnection.MyDatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	    	
	    	
	    	

	        stmt.setString(1, entry.getType());
	        stmt.setString(2, entry.getDescription());
	        stmt.setDouble(3, entry.getAmount());
	        stmt.setDate(4, java.sql.Date.valueOf(entry.getDate()));
	        stmt.setLong(5, entry.getEntryId());
	        stmt.setLong(6, entry.getUserId());
	        
	        System.out.println("Updating entry ID = " + entry.getEntryId());
		    int rowsAffected = stmt.executeUpdate();
		    System.out.println("Rows affected = " + rowsAffected);

	        return stmt.executeUpdate() > 0;
	        
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	    
	   

	}
	
	
	public BudgetEntry getEntryById(long entryId) {
	    String sql = "SELECT * FROM budget_entries WHERE entry_id = ?";
	    try (Connection conn = DatabaseConnection.MyDatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setLong(1, entryId);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            BudgetEntry entry = new BudgetEntry();
	            entry.setEntryId(rs.getLong("entry_id"));
	            entry.setUserId(rs.getLong("user_id"));
	            entry.setType(rs.getString("entry_type"));
	            entry.setDescription(rs.getString("description"));
	            entry.setAmount(rs.getDouble("amount"));
	            entry.setDate(rs.getDate("entry_date").toLocalDate());
	            return entry;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	
	public List<BudgetEntry> getAllEntriesByUserId(long userId) {
	    List<BudgetEntry> entries = new ArrayList<>();
	    String sql = "SELECT * FROM budget_entries WHERE user_id = ? ORDER BY entry_date DESC";

	    try (Connection conn = DatabaseConnection.MyDatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setLong(1, userId);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            BudgetEntry entry = new BudgetEntry();
	            entry.setEntryId(rs.getLong("entry_id"));
	            entry.setUserId(rs.getLong("user_id"));
	            entry.setType(rs.getString("entry_type"));
	            entry.setDescription(rs.getString("description"));
	            entry.setAmount(rs.getDouble("amount"));
	            entry.setDate(rs.getDate("entry_date").toLocalDate());

	            entries.add(entry);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return entries;
	}




}
