package Model;

public class User {
	private int id;
	private String username;
	private String pass;
	private String email;
	private String phonenumber;
	private int isSell;
	private int isAdmin;
	public User(int id, String username, String pass, String email, String phonenumber, int isSell, int isAdmin) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.phonenumber = phonenumber;
		this.isSell = isSell;
		this.isAdmin = isAdmin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getIsSell() {
		return isSell;
	}
	public void setIsSell(int isSell) {
		this.isSell = isSell;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}