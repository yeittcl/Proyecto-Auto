package proyecto;

import java.awt.*;
import javax.swing.JPanel;
import java.awt.*;

public class Panel extends JPanel {
    private KeyInputs keys;
    private Auto auto;
    private Pista pistaInterior, pistaExterior;
    
    public Panel(){
        super();
        auto = new Auto();
        pistaInterior = new Pista(640, 340, 660, 660);
        pistaExterior = new Pista(640,340,300,300);
        keys = new KeyInputs(this);
        this.setBackground(Color.GREEN);
        this.addKeyListener(keys);
    }
    public void update(){
        if(keys.getUp()){
            auto.changeFowardDirection(1);
            
        }
        if(keys.getDown()){
            auto.changeFowardDirection(-1);
        }
        if(keys.getRight() && (keys.getUp() || keys.getDown())){
            auto.changeAngleDirection(1);
            
        }
        if(keys.getLeft()&& (keys.getUp() || keys.getDown())){
            auto.changeAngleDirection(-1);
        }
        
        auto.updateAuto();
    }
    
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g.setColor(Color.BLACK);
        g.fillPolygon(auto);
    }
    
    
    
            
}
