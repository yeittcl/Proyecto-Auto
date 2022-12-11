package GUI;

import java.awt.*;
import javax.swing.*;
/**
 * Clase ventana heredada de JFrame que nos ayudara
 * como contenedor para los demas componentes visuales
 * @author Raul Zapata
 * @author Matias Lopez
 * @version %I%, %G%
 * @since 1.0
 */
public class Ventana extends JFrame{
    /**
     * Constructor de nuestra ventana que inicializa las variables
     * y da los valores default por todo el proyecto
     * 
     * @param panel Objecto panel que adjunta a nuestra ventana
     * @see Panel
     */
    public Ventana(JTabbedPane pestana){
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("juego");
        this.setSize(1280,720);
        this.add(pestana);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        
    } 
    
}
