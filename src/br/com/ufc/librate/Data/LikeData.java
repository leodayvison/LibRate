package br.com.ufc.librate.Data;

import br.com.ufc.librate.model.classes.Book;
import java.io.*;
import java.util.HashMap;

public class LikeData {
    static HashMap<String, Integer> likeMap = new HashMap<String, Integer>();

    public static HashMap<String, Integer> getLikeMap() {
        return LikeData.likeMap;
    }

    public static void loadMap() {
        for (Book b : BookData.getBookList()) {
            likeMap.put(b.getIdBook(), b.getLikes());
        }
    }

    public static void writeLikeMapToFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("likes.txt"))) {
            for (String id : likeMap.keySet()) {
                writer.write(id + ":" + likeMap.get(id));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileLike() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("likes.txt"))) {
            String line;
            likeMap.clear();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String id = parts[0];
                int like = Integer.parseInt(parts[1]);
                likeMap.put(id, like);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
