package proyecto;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputs implements KeyListener{
    
    private Panel panel;
    private boolean up, down, right, left;
    
    public KeyInputs(Panel panel){
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                up = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                up = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
        }
    }
    
    public boolean getUp(){
        return up;
    }
    public boolean getDown(){
        return down;
    }
    public boolean getLeft(){
        return left;
    }
    public boolean getRight(){
        return right;
    }
    
    
}
