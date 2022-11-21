/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.awt.*;
import javax.swing.JFrame;



public class Ventana extends JFrame{
    Panel juan;
    public Ventana(){
        super();
        juan = new Panel();
        
        this.setLayout(new BorderLayout());
        this.setTitle("hola jeje");
        this.setSize(1000,1000);
        this.add(juan);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        
        
        this.setVisible(true);
        
    } 
    
    
}
