package br.com.ufc.librate.exceptions;

public class BookAlreadyExistsException extends Exception{
	public BookAlreadyExistsException() {
		super("Este livro já existe");
	}

}
