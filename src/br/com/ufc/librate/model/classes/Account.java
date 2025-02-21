package br.com.ufc.librate.model.classes;
public abstract class Account {
	protected String user;
	protected String password;
	protected String bio;

	public Account(String user, String password) {
		this.user = user;
		this.password = password;
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

	public void changeBio(String bio) { this.bio = bio; }

	public void rateBook(float rating,Book book){

	}
}
