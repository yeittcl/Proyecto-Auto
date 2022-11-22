package proyecto;

import java.awt.*;
import javax.swing.JPanel;
import java.awt.*;

public class Panel extends JPanel {
    private int velX, velY;
    
    public Panel(){
        super();
        this.setBackground(Color.GREEN);
    }
    
    public void changeVelX(int delta){
        velX += delta;
        repaint();
    }
    public void changeVelY(int delta){
        velY += delta;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(300+velX, 300+velY, 100, 100);
    }
    
            
}
