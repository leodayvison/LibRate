package br.com.ufc.librate.Data;

import br.com.ufc.librate.collections.BookGenre;
import br.com.ufc.librate.model.classes.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookData {

    public static List<Book> bookList = new ArrayList<>();

    public static List<Book> getBookList() {
        return bookList;
    }

    public static void writeFileBook(String title,int year,String name, String bio, String publisher, BookGenre genre,
                                     String synopsis) throws IOException {
        if(!AuthorData.authorExists(name,bio)){
            AuthorData.writeFileAuthor(name, bio);
        }
        String dataBook = title + ":" + year + ":" + name + ":" + bio + ":" + publisher + ":" +
                genre.toString() + ":" + "0" + ":" + "0" + ":" + synopsis;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt", true))) {
            writer.write(dataBook);
            writer.newLine();
        } catch (IOException ioe) {
            ioe.getMessage();
        }
    }

    public static void readFileBook() throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            BookData.bookList.clear();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");

                String title = parts[0];
                int year = Integer.parseInt(parts[1]);
                String name = parts[2];
                String bio = parts[3];
                String publisher = parts[4];
                BookGenre genre = BookGenre.valueOf(parts[5]);
                float rating = Float.parseFloat(parts[6]);
                float ratingCount = Float.parseFloat(parts[7]);
                String synopsis = parts[8];

                Book book;
                if (name.equals(" ")) {
                    book = new Book(title,year,publisher,genre,rating,ratingCount,synopsis);
                } else {
                    book = new Book(title, year, name, bio, publisher, genre, rating,ratingCount,synopsis );
                }
                BookData.bookList.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
