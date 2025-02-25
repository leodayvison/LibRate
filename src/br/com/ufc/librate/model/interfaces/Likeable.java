package br.com.ufc.librate.model.interfaces;

import br.com.ufc.librate.model.classes.NormalAccount;

public interface Likeable {
    public void addLike();
    boolean isLiked(NormalAccount user);
    public void removelike();
    public int getLikes();
}
