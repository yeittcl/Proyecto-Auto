package proyecto;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame{
    public Ventana(Panel panel){
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("juego");
        this.setSize(1280,720);
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        
    } 
    
}
