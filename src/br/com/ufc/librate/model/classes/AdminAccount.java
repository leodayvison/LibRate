package br.com.ufc.librate.model.classes;

import java.io.IOException;

public class AdminAccount extends Account {
	public AdminAccount() throws IOException {
		super("admin", "9090");
	}

}
