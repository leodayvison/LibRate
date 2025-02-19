package br.com.ufc.librate.exceptions;

public class AccountAlreadyExistsException extends Exception{
	
	public AccountAlreadyExistsException() {
		super("Já existe uma conta com este nome de usuário");
	}

}
