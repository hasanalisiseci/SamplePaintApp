import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class Colors implements ActionListener {
    //Kullanıcıdan gelen inputları yakalayabilecek ve çizim
    // olanağı sağlayacak canvasımızı oluşturuyoruz
    PaintCanvas canvas;

    //constructor'ımızı oluşturduk
    public Colors(PaintCanvas canvas) {
        super();
        this.canvas = canvas;
    }

    //Combobox'ımızda seçilen rengi ayarlayan methodumuz
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> source = (JComboBox<String>) e.getSource();
        String color = (String) source.getSelectedItem();
        canvas.setColorCombo(color);
    }

}
