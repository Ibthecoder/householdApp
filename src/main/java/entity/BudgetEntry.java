package entity;
import java.time.LocalDate;

public class BudgetEntry {
	// define field for the Budget for the user:
	    private long entryId;
	    private long userId;
	    private String type; // income, expense, or recurring
	    private String description;
	    private double amount;
	    private LocalDate date;

	    // Default constructor
	    public BudgetEntry() {
	    }

	    // Constructor with all fields
	    public BudgetEntry(long userId, String type, String description, double amount, LocalDate date) {
	        this.userId = userId;
	        this.type = type;
	        this.description = description;
	        this.amount = amount;
	        this.date = date;
	    }

	    // Getters and Setters
	    public long getEntryId() {
	        return entryId;
	    }

	    public void setEntryId(long entryId) {
	        this.entryId = entryId;
	    }

	    public long getUserId() {
	        return userId;
	    }

	    public void setUserId(long userId) {
	        this.userId = userId;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public void setAmount(double amount) {
	        this.amount = amount;
	    }

	    public LocalDate getDate() {
	        return date;
	    }

	    public void setDate(LocalDate date) {
	        this.date = date;
	    }

	    @Override
	    public String toString() {
	        return "BudgetEntry [entryId=" + entryId + ", userId=" + userId + ", type=" + type +
	                ", description=" + description + ", amount=" + amount + ", date=" + date + "]";
	    }
	
	
	


}
