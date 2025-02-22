package br.com.ufc.librate.tools;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.ufc.librate.collections.BookGenre;
import br.com.ufc.librate.exceptions.BookAlreadyExistsException;
import br.com.ufc.librate.model.classes.Book;

public class BookManager {
	
	private static String[][] bookData;
	private static List<Book> bookList = new ArrayList<>();
	// TODO ler arquivo de livros e inicializar a lista com ela (igual no AccountManager)
	
	
	
	
	private static boolean isBookAdded(Book newBook) {
		for(Book book : bookList) {
			if (newBook.getTitle() == book.getTitle()) {
				return true;
			}
		}
		return false;
	}
	
	public static void addBook(Book book, JTable table) throws BookAlreadyExistsException{
		
		final Book newBook = new Book(book.getTitle(), book.getYear(), book.getAuthor().getName(), book.getAuthor().getBio(),
										book.getPublisher(), book.getGenre(), book.getRating(), book.getRatingCount(), book.getSynopsis());
		
		if (isBookAdded(newBook)){
			throw new BookAlreadyExistsException();
		} else {
			bookList.add(newBook);
			
			bookData = new String[bookList.size()][3];
			
			for(int i=0; i<bookList.size(); i++) {
				bookData[i][0] = bookList.get(i).getTitle();
				bookData[i][1] = bookList.get(i).getAuthor().getName();
				bookData[i][2] = bookList.get(i).getGenre().getGenreString();
			}
			
			
			String [] columns = {"Título", "Autor", "Gênero"};

			DefaultTableModel newModel = new DefaultTableModel(bookData, columns);
			table.setModel(newModel);
		}
		
	}
	
	

	
	
	public static String[][] getBookData() {
		return bookData;
	}

	public static void setBookData(String[][] bookData) {
		BookManager.bookData = bookData;
	}

	public static List<Book> getBookList() {
		return bookList;
	}

	public static void setBookList(List<Book> bookList) {
		BookManager.bookList = bookList;
	}
	
	
	

}
