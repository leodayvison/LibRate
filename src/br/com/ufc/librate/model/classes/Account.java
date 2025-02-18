package br.com.ufc.librate.model.classes;

public abstract class Account {
	protected String user;
	protected String password;
	protected String username;
	protected String bio;

	public Account(String user, String password, String username) {
		this.user = user;
		this.password = password;
		this.username = username;
	}

	public String getUser() {
		return user;
	}

	public void changeLogin(String login) {
		this.user = login;
	}

	public String getPassword() {
		return password;
	}

	public void changePassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void changeBio(String bio) { this.bio = bio; }
}
