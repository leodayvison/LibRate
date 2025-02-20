package br.com.ufc.librate.model.classes;

import java.util.List;
import br.com.ufc.librate.collections.BookGenre;


public class Comic extends Book{
	private String ilustrator;

	public Comic(String title, int year, String name, String bio, String publisher, BookGenre genre, float rating, float ratingCount, String synopsis, String ilustrator) {
		super(title, year, name, bio, publisher, genre, rating, ratingCount, synopsis);
		this.ilustrator = ilustrator;
	}

	public Comic(String title, int year, String publisher, BookGenre genre, float rating, float ratingCount, String synopsis, String ilustrator) {
		super(title, year, publisher, genre, rating, ratingCount, synopsis);
		this.ilustrator = ilustrator;
	}

	public String getIlustrator() {
		return ilustrator;
	}

	public void setIlustrator(String ilustrator) {
		this.ilustrator = ilustrator;
	}
}
