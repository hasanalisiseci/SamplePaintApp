import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {
    //Kullanıcıdan gelen inputları yakalayabilecek ve çizim
    // olanağı sağlayacak canvasımızı oluşturuyoruz
    PaintCanvas canvas;

    //constructor'ımızı oluşturduk
    public SliderListener(PaintCanvas canvas) {
        super();
        this.canvas = canvas;
    }

    //Değişime göre kalınlığımızı ayarlayan methodumuz.
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        int stroke = (int) source.getValue();
        canvas.setStroke(stroke);
    }
}
