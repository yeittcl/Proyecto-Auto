package proyecto;

import java.awt.*;
import javax.swing.JPanel;
import java.awt.*;

public class Panel extends JPanel {
    private KeyInputs keys;
    private int velX, velY;
    private int width, height;
    private int xCenter, yCenter;
    private int[] xPoints, yPoints;
    
    public Panel(){
        super();
        xCenter = 340;
        yCenter = 350;
        width = 80;
        height = 100;
        keys = new KeyInputs(this);
        this.setBackground(Color.GREEN);
        this.addKeyListener(keys);
    }
    
    public void changeVelX(int delta){
        velX = delta;
        xCenter += velX;
    }
    public void changeVelY(int delta){
        velY = delta;
        yCenter += velY;  
    }
    
    public void update(){
        if(keys.getUp()){
            this.changeVelY(-5);
        }
        if(keys.getDown()){
            this.changeVelY(5);
        }
        if(keys.getRight()){
            this.changeVelX(5);
        }
        if(keys.getLeft()){
            this.changeVelX(-5);
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        xPoints = new int[]{xCenter-(width/2), xCenter+width, xCenter+width, xCenter-(width/2)};
        yPoints = new int[]{yCenter-(height/2), yCenter-(height/2), yCenter+height, yCenter+height};
        g.fillPolygon(xPoints, yPoints, 4);
    }
    
            
}
