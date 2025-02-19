package Data;

import br.com.ufc.librate.model.classes.Account;
import br.com.ufc.librate.model.classes.Author;
import br.com.ufc.librate.model.classes.Book;
import br.com.ufc.librate.model.classes.NormalAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorData {
    public static List<Author> authorList = new ArrayList<>();

    public static List<Author> getAuthorList() {
        return authorList;
    }

    public static void writeFileAuthor(String name,String bio) throws IOException {
        Author author = new Author(name,bio);
        String dataAuthor = name + ":" + bio;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("authors.txt", true))) {
            writer.write(dataAuthor);
            writer.newLine();
        } catch (IOException ioe) {
            ioe.getMessage();
        }
    }

    public static void readFileAuthor(){
        try(BufferedReader reader = new BufferedReader(new FileReader("authors.txt"))){
            String line;
            AccountData.accountList.clear();
            while((line = reader.readLine()) != null){
                String[] parts = line.split(":");
                if(parts.length == 2){
                    String name = parts[0];
                    String bio = parts[1];
                    AuthorData.authorList.add(new Author(name,bio));
                }else{
                    System.out.println("Formato invalido:" + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
