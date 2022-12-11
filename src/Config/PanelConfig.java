package Config;
import java.awt.*;
import javax.swing.*;


public class PanelConfig extends JPanel{
    private PanelPistaExterior panelSliderExterior;
    private PanelPistaInterior panelSliderInterior;
    private JLabel labelExterior;
    private JLabel labelInterior;

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
