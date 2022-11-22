package proyecto;

public class Game {
    private Ventana ventana;
    private Panel panel;
    
    public Game(){
        panel = new Panel();
        ventana = new Ventana(panel);
    }
}
