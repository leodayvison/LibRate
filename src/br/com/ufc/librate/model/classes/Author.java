package br.com.ufc.librate.model.classes;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import br.com.ufc.librate.model.interfaces.*;


public class Author implements Likeable{

	private String name;
	private String bio;
	private int likes;
	private List<Book> publishedBooks;

	public Author(String name, String bio) {
		this.name = name;
		this.bio = bio;
		this.publishedBooks = new ArrayList<>();
		this.likes = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public List<Book> getPublishedBooks() {
		return publishedBooks;
	}

	public void setPublishedBooks(List<Book> publishedBooks) {
		this.publishedBooks = publishedBooks;
	}

	@Override
	public void addLike() {
		this.likes++;
	}

	@Override
	public int getLikes() {
		return likes;
	}

	@Override
	public boolean isLiked(NormalAccount user) {
		return user.getLikeds().contains(this);
	}

	@Override
	public void removelike() {
		this.likes--;
	}
}
