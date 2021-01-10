import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class Colors implements ActionListener {

    PaintCanvas canvas;

    public Colors(PaintCanvas canvas) {
        super();
        this.canvas = canvas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> source = (JComboBox<String>) e.getSource();
        String color = (String) source.getSelectedItem();
        canvas.setColorCombo(color);
    }

}
