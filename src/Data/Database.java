package Data;

import br.com.ufc.librate.model.classes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Book> catalogue = new ArrayList<>();
    public static List<Author> authorList = new ArrayList<>();

    public static List<Book> getCatalogue() {
        return catalogue;
    }

    public static List<Author> getAuthorList() {
        return authorList;
    }

    public static void checkAndCreateFiles() throws IOException {

        File[] files = {
                new File("users.txt"),
                new File("books.txt"),
                new File("authors.txt")
        };

        for (int i = 0;i < 3;i++){
            if (!files[i].exists()) {
                try {
                    files[i].createNewFile();
                    if(i==0){
                        AdminAccount adm = new AdminAccount();
                        AccountData.writeFileAccount(adm.getUser(), adm.getPassword());
                    }
                    System.out.println(files[i].getName() + " arquivo criado.");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println(files[i].getName() + "arquivo existente.");
            }
        }
    }

    public static void updateFiles() throws IOException {
        File[] files = {
                new File("users.txt"),
                new File("books.txt"),
                new File("authors.txt")
        };

        StringBuilder data = new StringBuilder();

        for(Account a : AccountData.accountList){
            data.append(a.getUser()).append(":").append(a.getPassword()).append(System.lineSeparator());
        }
        try(BufferedWriter bf = new BufferedWriter(new FileWriter("users.txt",false))){
            bf.write(data.toString());
        }catch (IOException ioe){
            ioe.getMessage();
        }

        data.setLength(0);

        for (Author a : AuthorData.authorList){
            data.append(a.getName()).append(":").append(a.getBio());
        }
        try(BufferedWriter bf = new BufferedWriter(new FileWriter("authors.txt",false))){
            bf.write(data.toString());
        }catch (IOException ioe){
            ioe.getMessage();
        }

        data.setLength(0);

        for (Book a : BookData.bookList){
            if(a.getAuthor() == null){
                data.append(a.getTitle()).append(":")
                        .append(a.getYear()).append(":")
                        .append(a.getPublisher()).append(":")
                        .append(a.getGenre().toString()).append(":")
                        .append(a.getRating()).append(":")
                        .append(a.getSynopsis()).append(":")
                        .append(a.getLikes()).append(System.lineSeparator());
            }else{
                data.append(a.getTitle()).append(":")
                        .append(a.getYear()).append(":")
                        .append(a.getAuthor().getName()).append(":")
                        .append(a.getAuthor().getBio()).append(":")
                        .append(a.getPublisher()).append(":")
                        .append(a.getGenre().toString()).append(":")
                        .append(a.getRating()).append(":")
                        .append(a.getSynopsis()).append(":")
                        .append(a.getLikes()).append(System.lineSeparator());

            }
        }try(BufferedWriter bf = new BufferedWriter(new FileWriter("books.txt",false))){
            bf.write(data.toString());
        }catch (IOException ioe){
            ioe.getMessage();
        }
    }






}

