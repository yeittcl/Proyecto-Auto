package Game;

import java.awt.*;

/**
 * Clase que define el auto que manejaremos e interactuaremos con el, este hereda
 * las cualidades de Polygon para poder generar rotaciones y tener una mayor personalizacion
 * @author Raul Zapata
 * @author Matias Lopez
 * @version %I%, %G%
 * @since 1.0
 */
public class Auto extends Polygon {
    
    /**
     * Variable double xCenter e yCenter que nos indica el centro del auto
     * Variable double theta que no dice el angulo de rotacion de nuestro auto
     * Variable double width, height y vel que nos indican el ancho del auto, el alto y la velocidad constante a la que se mueve
     * 
     */
    private double xCenter,yCenter;
    private double theta;
    private final double WIDTH = 40;
    private final double HEIGHT = 90;
    private double VEL = 2.5;
    
    
    /**
     * Constructor de la clase, se inicializan las variables a sus valores default y se indica la posicion inicial de los puntos
     */
    public Auto(){
        super();
        
        xCenter = 650;
        yCenter = 550;
        theta = 0;
        
        this.addPoint((int)(xCenter-(WIDTH/2)), (int)(yCenter-(HEIGHT/2)));
        this.addPoint((int)(xCenter+(WIDTH/2)), (int)(yCenter-(HEIGHT/2)));
        this.addPoint((int)(xCenter+(WIDTH/2)), (int)(yCenter+(HEIGHT/2)));
        this.addPoint((int)(xCenter-(WIDTH/2)), (int)(yCenter+(HEIGHT/2)));
        
    }
    
    /**
     * Metodo que nos permite indicar el vector direccion del auto
     * @param sign Double que nos indica el signo con el que queremos que funcione la velocidad
     */
    public void changeFowardDirection(double sign){
        xCenter+= (sign*VEL)*Math.cos(Math.toRadians(theta));
        yCenter+= (sign*VEL)*Math.sin(Math.toRadians(theta));
        
    }
    /**
     * Metodo que aumenta o decrece el angulo con el que trabajamos
     * @param sign Double que nos indica el signo con el que aumentamos o disminuimos el angulo
     */
    public void changeAngleDirection(double sign){
        theta+= (sign*2);
    }
    
    /**
     * Metodo que calcula la rotacion del auto mediante la rotacion euclidiana en un espacio 2D,
     * primero se calcula el vector de rotacion de la nueva posicion, luego se hace la rotacion intercambiando los puntos,
     * pero estos se rotan con respecto al origen de la pantalla, entonces se traslada al origen, se hace la rotacion y se vuelve a la posicion
     * original que estaba el centro
     */
    public void updateAuto(){
        
        double cos = Math.cos(Math.toRadians(theta));
        double sin = Math.sin(Math.toRadians(theta));
        
        this.xpoints[0] = (int)(xCenter + (WIDTH * cos) - ((-HEIGHT + 80)*sin));
        this.ypoints[0] = (int)(yCenter + (WIDTH * sin) + ((-HEIGHT + 80)*cos));
        
        this.xpoints[1] = (int)(xCenter + (WIDTH * cos) - ((HEIGHT - 80)*sin));
        this.ypoints[1] = (int)(yCenter + (WIDTH * sin) + ((HEIGHT - 80)*cos));
        
        this.xpoints[2] = (int)(xCenter + ((-WIDTH/2) * cos) - ((HEIGHT-60)*sin));
        this.ypoints[2] = (int)(yCenter + ((-WIDTH/2) * sin) + ((HEIGHT-60)*cos));
        
        this.xpoints[3] = (int)(xCenter + ((-WIDTH/2) * cos) - ((-HEIGHT+60)*sin));
        this.ypoints[3] = (int)(yCenter + ((-WIDTH/2) * sin) + ((-HEIGHT+60)*cos));
        
    }
    
    /**
     * metodo retorna xCenter
     * @return xCenter 
     */
    public double getXcenter(){
        return xCenter;
    }
    /**
     * metodo retorna yCenter
     * @return yCenter 
     */
    public double getYcenter(){
        return yCenter;
    }
    /**
     * metodo retorna theta
     * @return theta 
     */
    public double getAngle(){
        return theta;
    }
    /**
     * metodo que cambia la velocidad con el parametro que se le indica
     * @param vel 
     */
    public void setVelocity(double vel){
        VEL = vel;
    }
    
}
