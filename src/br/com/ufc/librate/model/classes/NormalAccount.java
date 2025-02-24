package br.com.ufc.librate.model.classes;

import br.com.ufc.librate.model.interfaces.*;
import br.com.ufc.librate.model.classes.Account;
import java.util.ArrayList;
import java.util.List;

public class NormalAccount extends Account implements CanLike, Likeable {
	
	

	public NormalAccount(String login, String password) {
		super(login, password);
		this.bio = "como o cu de quem esta lendo";
        this.likeds = new ArrayList<>();
		this.toReadBooks = new ArrayList<>();
		this.likedBooks = new ArrayList<>();
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
