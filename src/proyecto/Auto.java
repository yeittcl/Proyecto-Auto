package proyecto;

import java.awt.*;


public class Auto extends Polygon {
    
    private double xCenter,yCenter;
    private double theta;
    private final double WIDTH = 80;
    private final double HEIGHT = 100;
    private final double VEL = 2.5;
    
    public Auto(){
        super();
        
        xCenter = 340;
        yCenter = 350;
        theta = 90;
        
        this.addPoint((int)(xCenter-(WIDTH/2)), (int)(yCenter-(HEIGHT/2)));
        this.addPoint((int)(xCenter+(WIDTH/2)), (int)(yCenter-(HEIGHT/2)));
        this.addPoint((int)(xCenter+(WIDTH/2)), (int)(yCenter+(HEIGHT/2)));
        this.addPoint((int)(xCenter-(WIDTH/2)), (int)(yCenter+(HEIGHT/2)));
        
    }
    public void changeFowardDirection(double sign){
        xCenter+= (sign*VEL)*Math.cos(Math.toRadians(theta));
        yCenter+= (sign*VEL)*Math.sin(Math.toRadians(theta));
        
    }
    
    public void changeAngleDirection(double sign){
        theta+= (sign*2);
    }
    
    public void updateAuto(){
        
        double cos = Math.cos(Math.toRadians(theta));
        double sin = Math.sin(Math.toRadians(theta));
        
        this.xpoints[0] = (int)(xCenter+ (WIDTH * cos) - ((-HEIGHT + 80)*sin));
        this.ypoints[0] = (int)(yCenter+ (WIDTH * sin) + ((-HEIGHT + 80)*cos));
        
        this.xpoints[1] = (int)(xCenter+ (WIDTH * cos) - ((HEIGHT + 80)*sin));
        this.ypoints[1] = (int)(yCenter+ (WIDTH * sin) + ((HEIGHT + 80)*cos));
        
        this.xpoints[2] = (int)(xCenter+ ((-WIDTH/2) * cos) - (((HEIGHT/2))*sin));
        this.ypoints[2] = (int)(yCenter+ ((-WIDTH/2) * sin) + (((HEIGHT/2))*cos));
        
        this.xpoints[3] = (int)(xCenter+ ((-WIDTH/2) * cos) - (((-HEIGHT/2))*sin));
        this.ypoints[3] = (int)(yCenter+ ((-WIDTH/2) * sin) + (((-HEIGHT/2))*cos));
        
    }
    
}
