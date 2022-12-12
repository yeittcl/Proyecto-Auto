package GUI;
import Config.PanelPistaExterior;
import Config.PanelPistaInterior;
import Config.PistaHolder;
import java.awt.*;
import javax.swing.*;

/**
 * Clase panel heredada de JPanel que nos permite almacenar 
 * las clases que configuran la pista
 * @author Raul Zapata
 * @author Matias Lopez
 * @version %I%, %G%
 * @since 1.0
 */
public class PanelConfig extends JPanel{
    /**
     * las variables de los paneles que contienen los objetos que cambian los parametros de la pista
     * y una etiquetas que nos ayudan a diferenciarlas
     */
    private PanelPistaExterior panelSliderExterior;
    private PanelPistaInterior panelSliderInterior;
    private JLabel labelExterior;
    private JLabel labelInterior;
    
    /**
     * Constructor en que incializamos las variables y les damos los valores
     * por default, al igual que configurar el panel con sus caracteristicas,
     * acepta como parametros los holders de cada pista para hacer su uso
     * @param pistaHolderExterior
     * @param pistaHolderInterior 
     */
    public PanelConfig(PistaHolder pistaHolderExterior, PistaHolder pistaHolderInterior){
        super();
        this.setLayout(null);
        this.setBackground(Color.white);

        labelExterior = new JLabel("Radio pista exterior");
        labelExterior.setHorizontalAlignment(SwingConstants.CENTER);
        labelExterior.setBounds(250, 100, 190, 100);

        panelSliderExterior = new PanelPistaExterior(pistaHolderExterior);
        this.add(labelExterior);
        this.add(panelSliderExterior);

        labelInterior = new JLabel("Radio pista interior");
        labelInterior.setHorizontalAlignment(SwingConstants.CENTER);
        labelInterior.setBounds(800, 100, 190, 100);

        panelSliderInterior = new PanelPistaInterior(pistaHolderInterior);
        this.add(labelInterior);
        this.add(panelSliderInterior);
    }
}
