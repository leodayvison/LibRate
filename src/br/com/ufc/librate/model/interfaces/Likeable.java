package br.com.ufc.librate.model.interfaces;
import br.com.ufc.librate.model.classes.*;

public interface Likeable {
	public void addLike(); // adiciona um like ao objeto curtivel
    public void removelike();// diminui um like ao objeto curtivel
    public int getLikes();// retorna os likes do objeto curtivel
    public boolean isLiked(NormalAccount user);
}
