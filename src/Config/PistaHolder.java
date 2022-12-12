
package Config;
/**
 * clase holder de los parametros de la pista a cambiar,
 * en este caso hace holder del radio de la pista
 * @author Raul Zapata
 * @author Matias Lopez
 * @version %I%, %G%
 * @since 1.0
 */
public class PistaHolder{
    /**
     * variable que almacena el radio a holdear
     */
    private double radioHolder;
    
    /**
     * costructor por defecto, no contiene nada dentro
     */
    public PistaHolder(){
        
    }
    
    /**
     * metodo que retorna el radio
     * @return radioHolder
     */
    public double getRadioHolder(){
        return radioHolder;
    }
    /**
     * metodo que establece el radio a holdear
     * @param radioHolder 
     */
    public void setRadioHolder(double radioHolder){
        this.radioHolder = radioHolder;
    }
    
    
}
