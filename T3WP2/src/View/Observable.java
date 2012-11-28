package View;

import Model.character.Observer;
import org.newdawn.slick.Graphics;

public interface Observable {
    
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers(Graphics g);
    
}
