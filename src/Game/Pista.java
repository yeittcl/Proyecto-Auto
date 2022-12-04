package Game;
import java.awt.geom.Ellipse2D;

public class Pista {
    private double xCenter, yCenter;
    private double width, height, radius;
    private Ellipse2D circulo;
    
    public Pista(double xCenter, double yCenter, double width, double height){
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.width = width;
        this.height = height;
        this.radius = width/2;
        this.circulo = new Ellipse2D.Float((float)(xCenter-radius), (float)(yCenter-radius), (float)width, (float)height);
    }
    
    public double getXcenter(){return xCenter;}
    public double getYcenter(){return yCenter;}
    public double getRadius(){return radius;}
    public Ellipse2D getCirculo(){return circulo;}
}
