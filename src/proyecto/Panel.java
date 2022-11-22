package proyecto;

import java.awt.*;
import javax.swing.JPanel;
import java.awt.*;

public class Panel extends JPanel {
    
    public Panel(){
        super();
        this.setBackground(Color.GREEN);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(300, 300, 100, 100);
    }
    
            
}
