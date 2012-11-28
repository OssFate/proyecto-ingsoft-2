package Model.character;

public class HitBox {
    private int[] hitBox;
    
    public HitBox(int posX, int posY, int width, int height) {
        this.hitBox = new int[4];
        this.hitBox[0] = posX;
        this.hitBox[1] = posY;
        this.hitBox[2] = width;
        this.hitBox[3] = height;
        
    }
    
    public int[] getHitBox(){
        return this.hitBox;
    }
    
    public boolean colide(HitBox hb){
        //System.out.println((this.getHitBox()[0] + this.getHitBox()[3]) + " , " + hb.getHitBox()[0]);
        if (this.getHitBox()[0] < (hb.getHitBox()[0] + hb.getHitBox()[3]) 
                && (this.getHitBox()[0] + this.getHitBox()[3]) > hb.getHitBox()[0]){
            return true;
        }
        return false;
    }
    
}
