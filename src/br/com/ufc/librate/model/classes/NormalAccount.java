package br.com.ufc.librate.model.classes;

import br.com.ufc.librate.model.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class NormalAccount extends Account {

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
    public List<Author> getLikedAuthors() {
        return likedAuthors;
    }

}
