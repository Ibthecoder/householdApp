package entity;

public class UserRegister {
	// define field for user:
	private long id;
	private String UserName;
	private String email;
	private String password;
	
	// create constructor:
	public UserRegister () {
		
	}
	
	public UserRegister(String UserName, String email, String password) {
		this.UserName = UserName;
		this.email = email;
		this.password = password;
		
	}
	
	// getters / setters:
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return UserName;
	}
	
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String Password) {
		this.password = Password;
	}

	@Override
	public String toString() {
		return "UserRegister [id=" + id + ", UserName=" + UserName + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	
	
	
	

}
