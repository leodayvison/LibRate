package br.com.ufc.librate.model.classes;

import java.util.List;
import br.com.ufc.librate.collections.BookGenre;


public class Comic extends Book{
	private String ilustrator;

	public Comic(String title, int year, String name, String bio, List<Book> publishedBooks, String publisher,
			BookGenre genre, float rating, String synopsis, String ilustrator) {
		super(title, year, name, bio, publishedBooks, publisher, genre, rating, synopsis);
		this.ilustrator = ilustrator;
	}

	public Comic(String title, int year, Author author, BookGenre genre, float rating, String synopsis, String ilustrator) {
		super(title, year, author, genre, rating, synopsis);
		this.ilustrator = ilustrator;
	}

	public Comic(String title, int year, BookGenre genre, float rating, String synopsis, String ilustrator) {
		super(title, year, genre, rating, synopsis);
		this.ilustrator = ilustrator;
	}

	public String getIlustrator() {
		return ilustrator;
	}

	public void setIlustrator(String ilustrator) {
		this.ilustrator = ilustrator;
	}
}
