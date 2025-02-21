package br.com.ufc.librate.model.classes;

import br.com.ufc.librate.Data.BookData;
import br.com.ufc.librate.Data.LikeData;
import br.com.ufc.librate.collections.BookGenre;
import br.com.ufc.librate.model.interfaces.*;

public class Book implements Likeable {

	// array de comentarios no livro
	protected String idBook;
	protected String title;
	protected int year;
	protected Author author;
	protected String publisher;
	protected BookGenre genre;
	protected float rating;
	protected float ratingCount;
	protected String synopsis;
	protected int likes;

	//Livro com todas as informações.(autor que nao foi adicionado ainda na rede)
	public Book( String title, int year,String name, String bio, String publisher, BookGenre genre,
				float rating, float ratingCount, String synopsis) {
		this.idBook = "B" + BookData.getBookList().size();
		this.title = title;
		this.year = year;
        this.author = new Author(name, bio);
		this.publisher = publisher;
		this.genre = genre;
		this.rating = rating;
		this.ratingCount = ratingCount;
		this.synopsis = synopsis;
		this.likes = LikeData.getLikeMap().getOrDefault(this.idBook, 0);
	}

	//Livro com autores desconhecidos.
	public Book( String title, int year, String publisher, BookGenre genre,
				float rating, float ratingCount, String synopsis) {
		this.idBook = "B" + BookData.getBookList().size();
		this.title = title;
		this.year = year;
		this.publisher = publisher;
		this.genre = genre;
		this.rating = rating;
		this.ratingCount = ratingCount;
		this.synopsis = synopsis;
        this.likes = LikeData.getLikeMap().getOrDefault(this.idBook, 0);
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

	public float getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(float ratingCount) {
		this.ratingCount = ratingCount;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getIdBook() {
		return idBook;
	}

	public void setIdBook(String idBook) {
		this.idBook = idBook;
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
