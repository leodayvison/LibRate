package br.com.ufc.librate.collections;

public enum BookGenre {
	FICTION("Ficção"),
	NONFICTION("Não ficção"),
	FANTASY("Fantasia"),
	SCIENCE("Sci-Fi"),
	MYSTERY("Suspense"),
	THRILLER("Thriller"),
	ROMANCE("Romance"),
	HISTORICAL("Histórico"),
	ADVENTURE("Aventura"), 
	HORROR("Terror"),
	UNKNOWN("Desconhecido");
	
	private String genero;
	
	BookGenre(String genero){
		this.genero = genero;
	}
	
	public String getGenreString() {
		return this.genero;
	}
}
