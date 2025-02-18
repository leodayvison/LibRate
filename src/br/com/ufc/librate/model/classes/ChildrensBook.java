package br.com.ufc.librate.model.classes;

import java.util.List;
import br.com.ufc.librate.collections.BookGenre;

public class ChildrensBook extends Book{
	
	private String ageRange;
	private boolean hasIlustration;

	public ChildrensBook(String title, int year, String name, String bio, List<Book> publishedBooks,
						 String publisher, BookGenre genre, float rating, String synopsis, String ageRange, boolean hasIlustration) {
		super(title, year, name, bio, publishedBooks, publisher, genre, rating, synopsis);
		this.ageRange = ageRange;
		this.hasIlustration = hasIlustration;
	}

	public ChildrensBook(String title, int year, Author author, BookGenre genre, float rating,
						 String synopsis, String ageRange, boolean hasIlustration) {
		super(title, year, author, genre, rating, synopsis);
		this.ageRange = ageRange;
		this.hasIlustration = hasIlustration;
	}

	public ChildrensBook(String title, int year, BookGenre genre, float rating, String synopsis,
						 String ageRange, boolean hasIlustration) {
		super(title, year, genre, rating, synopsis);
		this.ageRange = ageRange;
		this.hasIlustration = hasIlustration;
	}

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public boolean isHasIlustration() {
		return hasIlustration;
	}

	public void setHasIlustration(boolean hasIlustration) {
		this.hasIlustration = hasIlustration;
	}

}
