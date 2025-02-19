package br.com.ufc.librate.model.classes;

import java.util.List;
import br.com.ufc.librate.collections.BookGenre;

public class ChildrensBook extends Book{
	
	private String ageRange;
	private boolean hasIlustration;

	public ChildrensBook(String title, int year, String name, String bio, String publisher, BookGenre genre, float rating, String synopsis, int likes, String ageRange, boolean hasIlustration) {
		super(title, year, name, bio, publisher, genre, rating, synopsis, likes);
		this.ageRange = ageRange;
		this.hasIlustration = hasIlustration;
	}

	public ChildrensBook(String title, int year, Author author, String publisher, BookGenre genre, float rating, String synopsis, int likes, String ageRange, boolean hasIlustration) {
		super(title, year, author, publisher, genre, rating, synopsis, likes);
		this.ageRange = ageRange;
		this.hasIlustration = hasIlustration;
	}

	public ChildrensBook(String title, int year, String publisher, BookGenre genre, float rating, String synopsis, int likes, String ageRange, boolean hasIlustration) {
		super(title, year, publisher, genre, rating, synopsis, likes);
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
