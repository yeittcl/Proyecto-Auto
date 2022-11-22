package proyecto;

public class Game implements Runnable{
    private Ventana ventana;
    private Panel panel;
    private Thread gameThread;
    
    public Game(){
        panel = new Panel();
        ventana = new Ventana(panel);
        panel.requestFocus();
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
    }
}
