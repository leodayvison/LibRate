package Data;

import br.com.ufc.librate.collections.BookGenre;
import br.com.ufc.librate.model.classes.Author;
import br.com.ufc.librate.model.classes.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookData {

    public static List<Book> bookList = new ArrayList<>();

    public static List<Book> getBookListList() {
        return bookList;
    }

    public static void writeFileBook(String title, int year, String name, String bio, String publisher,
                                     BookGenre genre, float rating, String synopsis, int likes) throws IOException {
        AuthorData.writeFileAuthor(name, bio);

        String dataBook = title + ":" + year + ":" + name + ":" + bio + ":" + publisher + ":" +
                genre.toString() + ":" + rating + ":" + synopsis + ":" + likes;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt", true))) {
            writer.write(dataBook);
            writer.newLine();
        } catch (IOException ioe) {
            ioe.getMessage();
        }
    }

    public static void writeFileBook(String title, int year, Author author, String publisher,
                                     BookGenre genre, float rating, String synopsis, int likes) throws IOException {
        String dataBook = title + ":" + year + ":" + author.getName() + ":" + author.getBio() + ":" + publisher + ":" +
                genre.toString() + ":" + rating + ":" + synopsis + ":" + likes;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt", true))) {
            writer.write(dataBook);
            writer.newLine();
        } catch (IOException ioe) {
            ioe.getMessage();
        }
    }

    public static void writeFileBook(String title, int year, String publisher, BookGenre genre,
                                     float rating, String synopsis, int likes) throws IOException {
        String dataBook = title + ":" + year + ":" + publisher + ":" + genre.toString() + ":" + rating + ":" + synopsis + ":" + likes;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt", true))) {
            writer.write(dataBook);
            writer.newLine();
        } catch (IOException ioe) {
            ioe.getMessage();
        }
    }

    public static void readFileBook() {
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            BookData.bookList.clear();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");

                if (parts.length == 7) {
                    String title = parts[0];
                    int year = Integer.parseInt(parts[1]);
                    String publisher = parts[2];
                    BookGenre genre = BookGenre.valueOf(parts[3]);
                    float rating = Float.parseFloat(parts[4]);
                    String synopsis = parts[5];
                    int likes = Integer.parseInt(parts[6]);

                    Book book = new Book(title, year, publisher, genre, rating, synopsis, likes);
                    BookData.bookList.add(book);

                } else if (parts.length == 9) {
                    String title = parts[0];
                    int year = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    String bio = parts[3];
                    String publisher = parts[4];
                    BookGenre genre = BookGenre.valueOf(parts[5]);
                    float rating = Float.parseFloat(parts[6]);
                    String synopsis = parts[7];
                    int likes = Integer.parseInt(parts[8]);

                    Author author = new Author(name,bio);

                    Book book = new Book(title, year, author, publisher, genre, rating, synopsis, likes);
                    BookData.bookList.add(book);

                } else if (parts.length == 10){
                    String title = parts[0];
                    int year = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    String bio = parts[3];
                    String likesAuthor = parts[4];
                    String publisher = parts[5];
                    BookGenre genre = BookGenre.valueOf(parts[6]);
                    float rating = Float.parseFloat(parts[7]);
                    String synopsis = parts[8];
                    int likes = Integer.parseInt(parts[9]);

                    Author author = null;
                    for(Author a : AuthorData.authorList){
                        if (a.getName().equals(name)){
                            author = a;
                            break;
                        }
                    }

                    Book book = new Book(title, year, author, publisher, genre, rating, synopsis, likes);
                    BookData.bookList.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
