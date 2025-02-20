package br.com.ufc.librate.Data;

import br.com.ufc.librate.model.classes.*;

import java.io.*;

import static br.com.ufc.librate.Data.LikeData.likeMap;

public class Database {

    public static void checkAndCreateFiles() throws IOException {

        File[] files = {
                new File("users.txt"),
                new File("books.txt"),
                new File("authors.txt"),
                new File("likes.txt")
        };

        for (int i = 0;i < 4;i++){
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
                        .append(" ").append(":")
                        .append(" ").append(":")
                        .append(a.getPublisher()).append(":")
                        .append(a.getGenre().toString()).append(":")
                        .append(a.getRating()).append(":")
                        .append(a.getRatingCount()).append(":")
                        .append(a.getSynopsis()).append(":")
                        .append(System.lineSeparator());
            }else{
                data.append(a.getTitle()).append(":")
                        .append(a.getYear()).append(":")
                        .append(a.getAuthor().getName()).append(":")
                        .append(a.getAuthor().getBio()).append(":")
                        .append(a.getPublisher()).append(":")
                        .append(a.getGenre().toString()).append(":")
                        .append(a.getRating()).append(":")
                        .append(a.getRatingCount()).append(":")
                        .append(a.getSynopsis()).append(":")
                        .append(System.lineSeparator());
            }
        }try(BufferedWriter bf = new BufferedWriter(new FileWriter("books.txt",false))){
            bf.write(data.toString());
        }catch (IOException ioe){
            ioe.getMessage();
        }

        data.setLength(0);

        for(String id : likeMap.keySet()){
            data.append(id).append(":")
                    .append(likeMap.get(id));
        }try(BufferedWriter bf = new BufferedWriter(new FileWriter("likes.txt",false))){
            bf.write(data.toString());
        }catch (IOException ioe){
            ioe.getMessage();
        }

    }


    public static void readFiles() throws IOException {
        AccountData.readFileAccount();
        AuthorData.readFileAuthor();
        BookData.readFileBook();
        LikeData.readFileLike();
    }
}

