package Game;

import GUI.PanelConfig;
import Config.PistaHolder;
import GUI.Ventana;
import GUI.Panel;
import javax.swing.JTabbedPane;
/**
 * Clase que nos permite separar procesos en nuestro proyecto mediante la implementacion de hilos y nos ayuda a encapsular
 * los diferentes objetos y clases, en el se encuentra el gameloop para dibujar los frames y que exista movimiento fluido
 * @author Raul Zapata
 * @author Matias Lopez
 * @version %I%, %G%
 * @since 1.0
 */
public class Game implements Runnable{
    /**
     * Variables de las clase ventana y panel para mostrar por pantalla
     * se crean los holders de cada pista y el jtabbed que nos permite tener dos paneles 
     * en el frame y mostrarlos por medio de cambios en el gui
     * y la creacion de un hilo para separar procesos y no exista "lag"
     * y limitamos la cantidad de frames a 144 por segundo mediante una variable global final
     */
    private Ventana ventana;
    private PistaHolder pistaHolderExterior;
    private PistaHolder pistaHolderInterior;
    private PanelConfig panelConfig;
    private JTabbedPane pestana;
    private Panel panel;
    private Thread gameThread;
    private final int FPS_CAP = 144;
    /**
     * Contructor de la clase, incializamos todas las variables a sus valores por default e inciamos
     * el hilo para que trabaje desde que se crea la instancia de esta clase
     */
    public Game(){
        pistaHolderExterior = new PistaHolder();
        pistaHolderInterior = new PistaHolder();
        panel = new Panel(pistaHolderExterior, pistaHolderInterior);
        panelConfig = new PanelConfig(pistaHolderExterior, pistaHolderInterior);
        pestana = new JTabbedPane();
        pestana.add( "juego",panel);
        pestana.add("configuracion",panelConfig);
        ventana = new Ventana(pestana);
        panel.requestFocus();
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    /**
     * Metodo Override de Runnable en el que ejecuta las lineas que hay dentro en el hilo correspondiente
     * dentro del metodo hacemos el calculo de los frames en cada segundo, proponemos el limite y calculamos el tiempo
     * que se demora cada frame en mostrarse por pantalla y que exista un delay en cada uno
     * @see Runnable
     */
    @Override
    public void run(){
        /**
         * timePerFrame calcula el tiempo que se demora un frame en 1 segundo, transformado a nanosegundos para
         * una mayor precision
         * lastFrame nos guarda el tiempo del ultimo frame calculado, que corresponde al tiempo actual de la maquina
         * lastCheck es una variable que nos permite guardar los frame por milisegundos para mostrar por pantalla y es algo
         * meramente estetico para ver como va el programa
         */
        double timePerFrame = 1000000000/FPS_CAP;
        long lastFrame = System.nanoTime();
        long now;
        int frames = 0;
        long lastCheck = System.currentTimeMillis();
        
        /**
         * este while infinito es nuestro gameloop que se encarga de actualizar y pintar cada frame
         * en nuestra pantalla
         * <p>
         * El funcionamiento de calculo es el siguiente: tenemos el tiempo que idealmente cada frame deberia demorar
         * entonces calculamos el tiempo actual de la maquina y lo restamos al tiempo que se demoro el anterior frame,
         * si esa diferencia es mayor o igual al tiempo ideal, significa que ya deberia haberse mostrado el frame,
         * si es menor por consiguiente el tiempo es muy corto aun y debe esperarse un poco para mostrarse
         */
        while(true){
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame){
                panel.update();
                panel.repaint();
                lastFrame = now;
                frames++;
            }
        /**
         * este if nos permite saber cuantos frames hubo en cada segundo, y ver si nuestro limite va de acuerdo a lo procesado
         */
            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: "+ frames);
                frames = 0;
            }
            
        }
        
    }
}
