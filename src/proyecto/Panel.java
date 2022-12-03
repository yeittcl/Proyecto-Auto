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
        pistaExterior = new Pista(640, 340, 660, 660);
        pistaInterior = new Pista(640,340,300,300);
        keys = new KeyInputs(this);
        this.setBackground(new Color(41,204,15));
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
        
        g2.setColor(new Color(83,84,85));
        g2.fill(pistaExterior.getCirculo());
        
        g2.setColor(new Color(76,194,58));
        g2.fill(pistaInterior.getCirculo());
        
        g2.setColor(Color.BLACK);
        g2.fill(auto);
    }
    
    
    
            
}
