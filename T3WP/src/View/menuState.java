package View;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class menuState extends BasicGameState{
    
    public Image menu;
    public Image icon;
    public int selX = 287;
    public int selY = 358;
    public int aux = 0;
    
    public int[][] pos = new int[5][2];

    public menuState(int state) {
        pos[0][0] = 287; pos[0][1] = 358;
        pos[1][0] = 277; pos[1][1] = 390;
        pos[2][0] = 315; pos[2][1] = 422;
        pos[3][0] = 315; pos[3][1] = 454;
        pos[4][0] = 340; pos[4][1] = 487;
    }
    
    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        gc.setShowFPS(false);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        menu = new Image("res/menu.png");
        icon = new Image("res/Icon.png");
        grphcs.drawImage(menu, 0, 0);
        grphcs.drawImage(icon, selX, selY);        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        if(input.isKeyPressed(Input.KEY_DOWN)){
            aux = aux + 1;
            if(aux == 5) aux = 0;
            selX = pos[aux][0];
            selY = pos[aux][1];
        }
        if(input.isKeyPressed(Input.KEY_UP)){
            aux = aux - 1;
            if(aux == -1) aux = 4;
            selX = pos[aux][0];
            selY = pos[aux][1];
        }
        if(input.isKeyPressed(Input.KEY_ENTER)){
            switch(aux){
                case 0:
                    sbg.enterState(1);
                    break;
                case 1:
                case 2:
                case 3:
                    sbg.enterState(2);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
    
}
