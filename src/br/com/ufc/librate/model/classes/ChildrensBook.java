package br.com.ufc.librate.model.classes;

import java.util.List;
import br.com.ufc.librate.collections.BookGenre;

public class ChildrensBook extends Book{
	
	private String ageRange;
	private boolean hasIlustration;

	public ChildrensBook(String title, int year, String name, String bio, String publisher, BookGenre genre, float rating, float ratingCount, String synopsis, String ageRange, boolean hasIlustration) {
		super(title, year, name, bio, publisher, genre, rating, ratingCount, synopsis);
		this.ageRange = ageRange;
		this.hasIlustration = hasIlustration;
	}

	public ChildrensBook(String title, int year, String publisher, BookGenre genre, float rating, float ratingCount, String synopsis, String ageRange, boolean hasIlustration) {
		super(title, year, publisher, genre, rating, ratingCount, synopsis);
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
