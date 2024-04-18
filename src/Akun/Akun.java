package Akun;

public class Akun {
	
	protected String username;
	protected String password;
	
	public Akun() {
		// TODO Auto-generated constructor stub
	}	
	
	public boolean login(String username, String password) {
		if(this.username.equals(username) && this.password.equals(password)) {
			return true;
		}
		return false;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Akun(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
