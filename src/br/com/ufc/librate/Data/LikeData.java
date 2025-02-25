package br.com.ufc.librate.Data;

import br.com.ufc.librate.model.classes.Book;
import java.io.*;
import java.util.HashMap;

public class LikeData {
    static HashMap<String, Integer> likeMap = new HashMap<>();

    public static HashMap<String, Integer> getLikeMap() {
        return LikeData.likeMap;
    }

    public static void loadLikes() {
        for (Book b : BookData.getBookList()) {
            if (LikeData.likeMap.containsKey(b.getIdBook())) {
                b.setLikes(likeMap.get(b.getIdBook()));
            } else {
                likeMap.put(b.getIdBook(), b.getLikes());
            }
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
