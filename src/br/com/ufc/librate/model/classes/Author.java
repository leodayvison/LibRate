package br.com.ufc.librate.model.classes;

import java.util.List;
import java.util.ArrayList;
import br.com.ufc.librate.model.interfaces.*;


public class Author implements Commentable, Likeable{

	private String name;
	private String bio;
	private int likes;
	private List<Book> publishedBooks;
	private List<Comment> commentList;

	public Author(String name, String bio, List<Book> publishedBooks) {
		this.name = name;
		this.bio = bio;
		this.publishedBooks = new ArrayList<>();
		this.commentList = new ArrayList<>();
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

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}



	public List<Book> getPublishedBooks() {
		return publishedBooks;
	}

	public void setPublishedBooks(List<Book> publishedBooks) {
		this.publishedBooks = publishedBooks;
	}

	@Override
	public void addComment(Comment comment) {
		commentList.add(comment);
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
