package Config;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Clase panel heredada de JPanel que configurar la pista interior(circulo mas grande)
 * mediante el objeto de swing JSlider
 * @author Raul Zapata
 * @author Matias Lopez
 * @version %I%, %G%
 * @since 1.0
 */
public class PanelPistaExterior extends JPanel implements ChangeListener{
    /**
     * objeto JSlider que crea un slider variable
     * y variable holder para hacer los cambios
     */
    private JSlider slider;
    private PistaHolder pistaHolder;
    
    /**
     * Constructor en que incializamos las variables y les damos los valores
     * por default, al igual que configurar el panel con sus caracteristicas,
     * establece el listener y la visualizacion de los numeros en el Slider
     * @param pistaHolder 
     */
    public PanelPistaExterior(PistaHolder pistaHolder){
        super();
        this.setBounds(250, 200, 220, 47);
        this.setBackground(Color.gray);
        this.pistaHolder = pistaHolder;

        slider = new JSlider(50,330,330);
        pistaHolder.setRadioHolder(330);
        slider.setMajorTickSpacing(70);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.addChangeListener(this);
        this.add(slider);
        this.setBackground(Color.white);
    }
    /**
     * metodo de la interfaz del ChangeListener que nos permite ver el puntero del Slider
     * y decidir que numero esta aputando
     * @param e 
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        pistaHolder.setRadioHolder((double)slider.getValue());
    }

}