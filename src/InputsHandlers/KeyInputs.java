package InputsHandlers;

import GUI.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Clase que permite el manejo de eventos por teclado mediante la interfaz oyente de
 * KeyListener
 * @author Raul Zapata
 * @author Matias Lopez
 * @version %I%, %G%
 * @since 1.0
 */
public class KeyInputs implements KeyListener{
    /**
     * variables booleanas que nos permite saber que tecla se esta oprimiendo o soltando
     * el nombre nos indica hacia donde queremos mover los objetos que utilizaran la clase
     */
    private Panel panel;
    private boolean up, down, right, left;
    /**
     * Constructor que incializa las variables
     * @param panel 
     */
    public KeyInputs(Panel panel){
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    /**
     * Metodo override de la interfaz, mediante un objeto keyevent, podemos saber que tecla 
     * estamos manteniendo presionando
     * @param e objeto de clase KeyEvent
     */
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
    /**
     * Metodo override de la interfaz, mediante un objeto keyevent, podemos saber que tecla 
     * dejamos de presionar
     * @param e objeto de clase KeyEvent
     */
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
    /**
     * metodo retorna el booleano up
     * @return up booleano
     */
    public boolean getUp(){
        return up;
    }
    /**
     * metodo retorna el booleano down
     * @return down booleano
     */
    public boolean getDown(){
        return down;
    }
    /**
     * metodo retorna el booleano left
     * @return left booleano
     */
    public boolean getLeft(){
        return left;
    }
    /**
     * metodo retorna el booleano right
     * @return rigth booleano
     */
    public boolean getRight(){
        return right;
    }
    
    
}
