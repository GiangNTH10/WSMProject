package WSMProject.WSMProject;

public class UserInfo {
	private String username;
	private String password;
	private String newPassword;

	public UserInfo(String username, String password) {
		this.username = username;
		this.password = password;
	}
	


	public UserInfo() {
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
}