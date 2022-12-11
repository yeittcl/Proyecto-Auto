package GUI;

import Config.PistaHolder;
import java.awt.*;
import javax.swing.JPanel;
import Game.Auto;
import InputsHandlers.KeyInputs;
import Game.Pista;

/**
 * Clase panel heredada de JPanel en el que dibujaremos
 * todo el apartado visual del proyecto y nos sirve de union entre las demas clases,
 * en ella se definen las funciones principales del juego y el apartado logico.
 * 
 * @author Raul Zapata
 * @author Matias Lopez
 * @version %I%, %G%
 * @since 1.0
 */
public class Panel extends JPanel {
    /**
     * Keys nos permite hacer listening de los inputs del teclado
     * Auto nuestra clase auto a dibujar
     * Pista es el fondo y la pista por donde nuestro coche debe conducir
     * isColliding nos indica si existe colision con los bordes de la pista
     */
    private KeyInputs keys;
    private Auto auto;
    private Pista pistaInterior, pistaExterior;
    
    private boolean isColliding;
    
    /**
     * Constructor en que incializamos las variables y les damos los valores
     * por default, al igual que configurar el panel con sus caracteristicas
     */
    public Panel(PistaHolder pistaHolderExterior, PistaHolder pistaHolderInterior){
        super();
        auto = new Auto();
        pistaExterior = new Pista(640, 340, 660, 660);
        pistaExterior.setHolder(pistaHolderExterior);
        pistaInterior = new Pista(640,340,300,300);
        pistaInterior.setHolder(pistaHolderInterior);
        keys = new KeyInputs(this);
        
        this.isColliding = false;
        
        this.setBackground(new Color(41,204,15));
        this.addKeyListener(keys);
    }
    
    /**
     * Metodo que nos permite separar la parte logica del juego de la grafica,
     * en el se calculan las colisiones con la pista, se manejan los eventos de teclados,
     * se cambian los estados de nuestros objetos a dibujar,etc
     * <p>
     * este metodo siempre debe ir antes de la funcion repaint, ya que es lo que se procesa detras
     * del buffer del pintado
     * @see Game
     */
    public void update(){
        
        this.checkCollision();
        
        if(keys.getUp()){
            auto.changeFowardDirection(1);
            
        }
        if(keys.getDown()){
            auto.changeFowardDirection(-1);
        }
        if(keys.getRight() && (keys.getUp() || keys.getDown())){
            auto.changeAngleDirection(1);
            
        }
        if(keys.getLeft()&& (keys.getUp() || keys.getDown())){
            auto.changeAngleDirection(-1);
        }
        
        auto.updateAuto();
        pistaExterior.updatePista();
        pistaInterior.updatePista();
    }
    /**
     * Metodo que calcula la distancia euclidiana mediante la suma de las distancias al cuadrado entre dos puntos, 
     * en este caso desde el centro de nuestro auto
     * al centro de la piesta, parametrizada como una elipse circular
     * @param auto El objeto que manejamos y movemos
     * @param pista La pista contra la que queremos calcular la distancia euclidiana
     * @return dist La distancia calculada entre los dos puntos
     */
    public double calcDistance(Auto auto, Pista pista){
        double xDist = (auto.getXcenter()-pista.getXcenter())*(auto.getXcenter()-pista.getXcenter());
        double yDist = (auto.getYcenter()-pista.getYcenter())*(auto.getYcenter()-pista.getYcenter());
        double dist = Math.sqrt(xDist + yDist);
        return dist;
    }
    /**
     * Metodo que calcula la colision entre nuestro auto y las pistas, este se hace mediante
     * el radio que produce la pista y la distancia que existe entre el auto y su centro,
     * si la distancia es mayor que el radio
     * el auto no esta colisionando con la pista
     *<p>
     * Este metodo tiene un margen de +- 35 pixeles, por el calculo que se hace con el centro del auto
     * y no con cada punto de este, pero beneficia la simplicidad y la velocidad
     */
    public void checkCollision(){
        double distInside = this.calcDistance(auto, pistaInterior);
        double distOutside = this.calcDistance(auto, pistaExterior);
        
        if(distInside <= pistaInterior.getRadius()+35 || distOutside >= pistaExterior.getRadius()-35){
            isColliding = true;
        }
        else{
            isColliding = false;
        }
    }
    
    /**
     * Metodo Override de JPanel que nos permite pintar en pantalla
     * mediante la clase Graphics y Graphics2D, dentro de este se especifican
     * los colores a utilizar y el orden de pintado 
     * @param g Clase grafica que nos permite pintar sobre el panel y mostrarlo por pantalla 
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(new Color(83,84,85));
        g2.fill(pistaExterior.getCirculo());
        
        g2.setColor(new Color(76,194,58));
        g2.fill(pistaInterior.getCirculo());
        
        if(!isColliding){
            g2.setColor(Color.blue);
        }else{
            g2.setColor(Color.red);
        }
        g2.fill(auto);
    }
    
    
    
            
}
