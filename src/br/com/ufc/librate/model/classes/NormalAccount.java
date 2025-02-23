package br.com.ufc.librate.model.classes;

import br.com.ufc.librate.model.interfaces.*;
import br.com.ufc.librate.model.classes.Account;
import java.util.ArrayList;
import java.util.List;

public class NormalAccount extends Account implements CanLike, Likeable {
	private String bio;
	private int likes;
	private List<Book> toReadBooks;
	private  List<Book> likedBooks;
	private List<Likeable> likeds;
	

	public NormalAccount(String login, String password) {
		super(login, password);
		this.bio = "Eu amo livros☝️🤓";
        this.likeds = new ArrayList<>();
		this.toReadBooks = new ArrayList<>();
		this.likedBooks = new ArrayList<>();
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

	public List<Likeable> getLikeds() {
		return likeds;
	}

	public void setLikeds(List<Likeable> likeds) {
		this.likeds = likeds;
	}

	@Override
	public void like(Likeable likeable) {
			likeds.add(likeable);
			likeable.addLike();
	}

	@Override
	public void dislike(Likeable likeable) {
			likeds.remove(likeable);
			likeable.removelike();
	}

	@Override
	public void addLike() {
		this.likes++;
	}

	@Override
	public void removelike() {
		this.likes--;
	}

	@Override
	public int getLikes() {
		return this.likes;
	}

	@Override
	public boolean isLiked(NormalAccount user) {
		return user.getLikeds().contains(this);
	}
}
