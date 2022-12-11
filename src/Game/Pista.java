package Game;
import Config.PistaHolder;
import java.awt.geom.Ellipse2D;
/**
 * Clase que define la pista por la que nuestro auto conducira, esta pensada como un circulo
 * para una mejor simplificacion
 * @author Raul Zapata
 * @author Matias Lopez
 * @version %I%, %G%
 * @since 1.0
 */
public class Pista {
    /**
     * varibles xCenter e yCenter definen el centro del circulo
     * variables width, height y radius indican el ancho, alto y radio respectivamente
     * y nuestro objeto Ellipse2D que guarda todos estos datos y crea el circulo a mostrar
     */
    private double xCenter, yCenter;
    private double width, height, radius;
    private Ellipse2D circulo;
    private PistaHolder pistaHolder;
    
    /**
     * Constructor de la clase, a esta le pasamos el alto, ancho y el centro del circulo
     * se incializan las varibles y se crea el circulo con estas variables
     * @param xCenter variable double que indica el centro en x
     * @param yCenter variable double que indica el centro en y
     * @param width variable double que indica el ancho
     * @param height variable double que indica el alto
     */
    public Pista(double xCenter, double yCenter, double width, double height){
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.width = width;
        this.height = height;
        this.radius = width/2;
        
        /**
         * Ellipse2D crea un cuadrado dado un x, un y, un ancho y alto, y este dibuja un circulo inscrito entre esos bordes
         * el x e y estan en la parte superior izquierda del cuadrado imaginario, entonces con simples calculos se puede generalizar a un radio y un centro
         * en vez de pensarlo como un cuadrado
         */
        this.circulo = new Ellipse2D.Float((float)(xCenter-radius), (float)(yCenter-radius), (float)width, (float)height);
    }
    /**
     * metodo retorna el double xCenter
     * @return xCenter
     */
    public double getXcenter(){return xCenter;}
    /**
     * metodo retorna el double yCenter
     * @return yCenter
     */
    public double getYcenter(){return yCenter;}
    /**
     * metodo retorna el radio
     * @return radius
     */
    public double getRadius(){return radius;}
    /**
     * metodo retorna el objeto Ellipse2D
     * @return circulo 
     */
    public Ellipse2D getCirculo(){return circulo;}
    
    public void setHolder(PistaHolder pistaHolder){
        this.pistaHolder = pistaHolder;
        
    }
    public void updatePista(){
        radius = pistaHolder.getRadioHolder();
        Ellipse2D circuloAux = new Ellipse2D.Float((float)(xCenter-radius),(float)(yCenter-radius),(float)(radius*2),(float)(radius*2));
        circulo = circuloAux;
    }
}
