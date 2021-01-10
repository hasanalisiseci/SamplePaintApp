import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {

    PaintCanvas canvas;

    public SliderListener(PaintCanvas canvas) {
        super();
        this.canvas = canvas;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        int stroke = (int) source.getValue();
        canvas.setStroke(stroke);
    }
}
