package Config;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelPistaExterior extends JPanel implements ChangeListener{
    private JSlider slider;
    private PistaHolder pistaHolder;

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

    @Override
    public void stateChanged(ChangeEvent e) {
        pistaHolder.setRadioHolder((double)slider.getValue());
    }

}