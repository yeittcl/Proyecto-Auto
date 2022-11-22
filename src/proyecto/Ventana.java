
package proyecto;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame{
    Panel juan;
    public Ventana(){
        super();
        juan = new Panel();
        
        this.setLayout(new BorderLayout());
        this.setTitle("juego");
        this.setSize(1000,1000);
        this.add(juan);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        
        
        this.setVisible(true);
        
    } 
    
    
}
