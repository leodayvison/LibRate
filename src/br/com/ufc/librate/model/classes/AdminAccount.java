package br.com.ufc.librate.model.classes;

import java.util.List;

public class AdminAccount extends Account {
	private List<Book> Catalogue;

	public AdminAccount(String user, String password, String username) {
		super(user, password, username);
	}

	public List<Book> getCatalogue() {
		return Catalogue;
	}

	public void setCatalogue(List<Book> catalogue) {
		Catalogue = catalogue;
	}	
}
