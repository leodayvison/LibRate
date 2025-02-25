package br.com.ufc.librate.model.classes;

import br.com.ufc.librate.model.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class NormalAccount extends Account implements CanLike {

	private final List<Author> likedAuthors;

	public NormalAccount(String login, String password,String bio) {
		super(login, password);
		this.bio = bio;
        this.likedAuthors = new ArrayList<>();
		this.toReadBooks = new ArrayList<>();
		this.likedBooks = new ArrayList<>();
    }
	public NormalAccount(String login, String password) {
		super(login, password);
		this.bio = "Eu amo livros!!";
		this.likedAuthors = new ArrayList<>();
		this.toReadBooks = new ArrayList<>();
		this.likedBooks = new ArrayList<>();
	}

	@Override
	public void like(Likeable likeable) {
			if (likeable instanceof Book) {
				this.getLikedBooks().add((Book) likeable);
			}else if(likeable instanceof Author){
				this.getLikedAuthors().add((Author) likeable);
			}
			likeable.addLike();
	}

	@Override
	public void dislike(Likeable likeable) {
			if(likeable instanceof Book){
				this.getLikedBooks().remove(likeable);
			}else if(likeable instanceof Author){
				this.getLikedAuthors().remove(likeable);
			}
			likeable.removelike();
	}

	public void makeRate(Book book,float rate){
		if (rate < 0 || rate > 5) {
			throw new IllegalArgumentException("A avaliação deve estar entre 0 e 5.");
		}

		float totalRating = (book.getRating() * book.getRatingCount()) + rate;

		float newCount = book.getRatingCount() + 1;
		book.setRatingCount(newCount);

		book.setRating(totalRating / newCount);
	}

    @Override
    public List<Author> getLikedAuthors() {
        return likedAuthors;
    }

}
