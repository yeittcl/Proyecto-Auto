package proyecto;

import java.awt.*;
import javax.swing.JPanel;
import java.awt.*;

public class Panel extends JPanel {
    private KeyInputs keys;
    private Auto auto;
    
    public Panel(){
        super();
        auto = new Auto();
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
        if(keys.getRight()){
            auto.changeAngleDirection(1);
        }
        if(keys.getLeft()){
            auto.changeAngleDirection(-1);
        }
    }
    
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        auto.updateAuto();
        g.fillPolygon(auto);
    }
    
    
    
            
}
