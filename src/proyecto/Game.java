package proyecto;

public class Game implements Runnable{
    private Ventana ventana;
    private Panel panel;
    private Thread gameThread;
    private final int FPS_CAP = 120;
    
    public Game(){
        panel = new Panel();
        ventana = new Ventana(panel);
        panel.requestFocus();
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double timePerFrame = 1000000000/FPS_CAP;
        long lastFrame = System.nanoTime();
        long now;
        while(true){
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame){
                panel.repaint();
                lastFrame = now;
            }
            
        }
        
    }
}
