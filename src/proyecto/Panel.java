package proyecto;

import java.awt.*;
import javax.swing.JPanel;
import java.awt.*;

public class Panel extends JPanel {
    private int velX, velY;
    
    public Panel(){
        super();
        this.setBackground(Color.GREEN);
        this.addKeyListener(new KeyInputs(this));
    }
    
    public void changeVelX(int delta){
        velX += delta;
        
    }
    public void changeVelY(int delta){
        velY += delta;
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(300+velX, 300+velY, 100, 100);
        //repaint();
    }
    
            
}
