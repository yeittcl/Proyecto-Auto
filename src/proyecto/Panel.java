
package proyecto;

import java.awt.*;
import javax.swing.JPanel;
import java.awt.*;


public class Panel extends JPanel {
    int[] puntoX;
    int[] puntoY;
    
    public Panel(){
        super();
        this.setBackground(Color.GREEN);
          
        this.puntoX = new int[]{100,200,200,300,300,200,200,300,300,200,200,100,100,0,0,100,100,0,0,100};
        this.puntoY = new int[]{100,100,200,200,300,300,400,400,500,500,560,560,500,500,400,400,300,300,200,200};
        
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawPolygon(puntoX,puntoY,20);
    }
    
            
}
