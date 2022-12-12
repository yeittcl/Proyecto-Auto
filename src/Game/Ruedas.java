
package Game;
import java.awt.*;

/**
 * Clase heredada de Polygon que define las ruedas y permite que se muevan, rotan con el mismo angulo del auto y siguen las esquinas de este
 * como un auto de verdad
 * @author Raul Zapata
 * @author Matias Lopez
 * @version %I%, %G%
 * @since 1.0
 */
public class Ruedas extends Polygon{
    private double xCenter, yCenter;
    private double theta;
    private final double WIDTH = 8;
    private final double HEIGHT = 10;
    private Auto auto;
    
    /**
     * construcotr que define las variables, crea los puntos para que se cree el polygon
     * da el angulo original y guarda la instancia del auto
     * @param auto 
     */
    public Ruedas(Auto auto){
        super();
        this.auto = auto;
        theta = auto.getAngle()+90;
        this.addPoint((int)(xCenter-WIDTH/2),(int)(yCenter-HEIGHT/2));
        this.addPoint((int)(xCenter+WIDTH/2),(int)(yCenter-HEIGHT/2));
        this.addPoint((int)(xCenter+WIDTH/2),(int)(yCenter+HEIGHT/2));
        this.addPoint((int)(xCenter-WIDTH/2),(int)(yCenter+HEIGHT/2));
    }

    /**
     * metodo que establece la direccion de la rueda
     */
    public void changeAngleDirection(){
        theta = auto.getAngle()+90;
    }
    /**
     * metodo que permite el seguimiento del centro de la rueda con el centro de alguna esquina del auto
     * acepta un parametro que nos dice que punta del auto seguir
     * @param i 
     */
    public void follow(int i){
       xCenter = auto.xpoints[i] ;
       yCenter = auto.ypoints[i] ;
    }
    /**
     * metodo que actualiza los puntos de la rueda, de igual forma que el auto @see Auto
     * al hacer el cambio de direccion
     * @param i 
     */
    public void updateWheel(int i){

        double cos = Math.cos(Math.toRadians(theta));
        double sin = Math.sin(Math.toRadians(theta));

        this.xpoints[0] = (int)(xCenter + (WIDTH)*cos - (-HEIGHT)*sin);
        this.ypoints[0] = (int)(yCenter + (WIDTH)*sin + (-HEIGHT)*cos);

        this.xpoints[1] = (int)(xCenter + ((WIDTH)*cos - (HEIGHT)*sin));
        this.ypoints[1] = (int)(yCenter + ((WIDTH)*sin + (HEIGHT)*cos));

        this.xpoints[2] = (int)(xCenter + ((-WIDTH)*cos - (HEIGHT)*sin));
        this.ypoints[2] = (int)(yCenter + ((-WIDTH)*sin + (HEIGHT)*cos));

        this.xpoints[3] = (int)(xCenter + ((-WIDTH)*cos - (-HEIGHT)*sin));
        this.ypoints[3] = (int)(yCenter + ((-WIDTH)*sin + (-HEIGHT)*cos));

        xCenter = auto.xpoints[i];
        yCenter = auto.ypoints[i];
    }
    /**
     * metodo que retorna el angulo
     * @return theta
     */
    public double getAngle(){
        return theta;
    }
}