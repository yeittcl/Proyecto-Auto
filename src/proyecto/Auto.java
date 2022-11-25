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
    
    
}
