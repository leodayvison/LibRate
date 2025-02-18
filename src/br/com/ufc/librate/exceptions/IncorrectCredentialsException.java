package br.com.ufc.librate.exceptions;

public class IncorrectCredentialsException extends Exception{
	
	public IncorrectCredentialsException() {
		super("Usuário ou senha inválidos");
	}
}
