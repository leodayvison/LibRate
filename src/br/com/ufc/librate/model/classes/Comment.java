package br.com.ufc.librate.model.classes;

import br.com.ufc.librate.model.interfaces.*;


public class Comment implements Likeable{
	private String content;
    private int likes;

    public Comment(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public void addLike() {
        this.likes++;
    }

    @Override
    public void removelike() {
        this.likes--;
    }

    @Override
    public int getLikes() {
        return this.likes;
    }

    @Override
    public boolean isLiked(NormalAccount user) {
        return user.getLikeds().contains(this);
    }
}
