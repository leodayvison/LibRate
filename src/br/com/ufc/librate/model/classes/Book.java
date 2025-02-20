package br.com.ufc.librate.model.classes;

import java.util.ArrayList;
import java.util.List;
import br.com.ufc.librate.collections.BookGenre;
import br.com.ufc.librate.model.interfaces.*;

public class Book implements Likeable, Commentable{
	
	// array de comentarios no livro
	protected String title;
	protected int year;
	protected Author author;
	protected String publisher;
	protected BookGenre genre;
	protected float rating;
	protected String synopsis;
	protected int likes;
	protected List<Comment> commentList;

	//Livro com todas as informações.(autor que nao foi adicionado ainda na rede)
	public Book(String title, int year,String name, String bio, List<Book> publishedBooks, String publisher, BookGenre genre, float rating,
			String synopsis) {
		super();
		this.title = title;
		this.year = year;
		this.author = new Author(name, bio, publishedBooks);
		this.publisher = publisher;
		this.genre = genre;
		this.rating = rating;
		this.synopsis = synopsis;
		this.likes = 0;
		this.commentList = new ArrayList<>();
	}
	
	//Autor ja adicionado na rede.
	public Book(String title, int year,Author author, BookGenre genre, float rating,
			String synopsis) {
		super();
		this.title = title;
		this.year = year;
		this.author = author;
		this.genre = genre;
		this.rating = rating;
		this.synopsis = synopsis;
	}

	//Livro com autores desconhecidos.
	public Book(String title, int year, BookGenre genre, float rating,
			String synopsis) {
		super();
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.rating = rating;
		this.synopsis = synopsis;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public BookGenre getGenre() {
		return genre;
	}

	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
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

	@Override
	public void addComment(Comment comment) {
		commentList.add(comment);
	}	

}
