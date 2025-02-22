package br.com.ufc.librate.tools;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.ufc.librate.Data.BookData;
import br.com.ufc.librate.collections.BookGenre;
import br.com.ufc.librate.exceptions.BookAlreadyExistsException;
import br.com.ufc.librate.model.classes.Book;

public class BookManager {
	
	private static String[][] bookData;
	// TODO ler arquivo de livros e inicializar a lista com ela (igual no AccountManager)


	public static String[][] getBookData() {
		return bookData;
	}

	private static boolean isBookAdded(Book newBook) {
		for(Book book : BookData.getBookList()) {
			if (newBook.getTitle() == book.getTitle()) {
				return true;
			}
		}
		return false;
	}
	
	public static void addBook(Book book, JTable table) throws BookAlreadyExistsException{
			
			bookData = new String[BookData.getBookList().size()][3];
			
			for(int i = 0; i< BookData.getBookList().size(); i++) {
				bookData[i][0] = BookData.getBookList().get(i).getTitle();
				if(BookData.getBookList().get(i).getAuthor() != null) {
					bookData[i][1] = BookData.getBookList().get(i).getAuthor().getName();
				}else{
					bookData[i][1] = "Desconhecido";
				}
				bookData[i][2] = BookData.getBookList().get(i).getGenre().getGenreString();
			}

			String [] columns = {"Título", "Autor", "Gênero"};

			DefaultTableModel newModel = new DefaultTableModel(bookData, columns);
			table.setModel(newModel);
	}
}

