
package Game;
import java.awt.*;
import static javax.swing.SpringLayout.WIDTH;

public class Ruedas extends Polygon{
    private double xCenter, yCenter;
    private double theta;
    private final double WIDTH = 8;
    private final double HEIGHT = 10;
    private final double GENERAL_VEL = 2.5;
    private Auto auto;

    public Ruedas(Auto auto){
        super();
        this.auto = auto;
        theta = auto.getAngle()+90;
        this.addPoint((int)(xCenter-WIDTH/2),(int)(yCenter-HEIGHT/2));
        this.addPoint((int)(xCenter+WIDTH/2),(int)(yCenter-HEIGHT/2));
        this.addPoint((int)(xCenter+WIDTH/2),(int)(yCenter+HEIGHT/2));
        this.addPoint((int)(xCenter-WIDTH/2),(int)(yCenter+HEIGHT/2));
    }


    public void changeAngleDirection(){
        theta = auto.getAngle()+90;
    }
    public void follow(int i){
       xCenter = auto.xpoints[i] ;
       yCenter = auto.ypoints[i] ;
    }
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
    public double getAngle(){
        return theta;
    }
}