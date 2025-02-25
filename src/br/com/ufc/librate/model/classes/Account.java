package br.com.ufc.librate.model.classes;

import br.com.ufc.librate.model.interfaces.Likeable;

import java.util.List;

public abstract class Account {
	protected String user;
	protected String password;
	protected String bio;
	protected int likes;
	protected List<Book> toReadBooks;
	protected  List<Book> likedBooks;
	protected List<Author> likedAuthors;

	public int getLikes() {
		return likes;
	}

	public List<Author> getLikedAuthors() {
		return likedAuthors;
	}

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
	
	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public List<Book> getToReadBooks() {
		return toReadBooks;
	}

	public void setToReadBooks(List<Book> readBooks) {
		this.toReadBooks = readBooks;
	}

	public List<Book> getLikedBooks() {
		return likedBooks;
	}

	public void setLikedBooks(List<Book> likedBooks) {
		this.likedBooks = likedBooks;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

}
