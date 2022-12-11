package Config;
import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelPistaInterior extends JPanel implements ChangeListener{
    private JSlider slider;
    private PistaHolder pistaHolder;

    public PanelPistaInterior(PistaHolder pistaHolder){
        super();
        this.setBounds(800, 200, 220, 47);
        this.setBackground(Color.gray);
        this.pistaHolder = pistaHolder;

        slider = new JSlider(50,250,100);
        pistaHolder.setRadioHolder(50);
        slider.setMajorTickSpacing(50);
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