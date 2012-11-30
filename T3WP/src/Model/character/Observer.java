package Model.character;

public interface Observer {
    public void update(boolean b);
    public HitBox getBox();
    public void setColide(boolean b);
}
