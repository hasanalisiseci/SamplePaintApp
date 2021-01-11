import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class Main {

    static int w = 1000, h = 700;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        //// Bir JFrame  olusturuyoruz.
        JFrame frame = new JFrame("Basic Paint App");
        // Pencere kapatıldığında programdan çıkın
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Pencere boyutu başlangıç boyutu
        frame.setSize(w, h);

        frame.setLocationRelativeTo(null);

        // Paint canvası oluşturalım
        PaintCanvas canvas = new PaintCanvas(w, h);

        // Çerçeve ekleyelim
        JPanel paint_frame = new JPanel();
        frame.getContentPane().add(paint_frame, BorderLayout.CENTER);
        JPanel top_bar = new JPanel();
        frame.getContentPane().add(top_bar, BorderLayout.NORTH);

        canvas.setPreferredSize(new Dimension(w, h));
        paint_frame.add(canvas);

        // Silme butonu oluşturup penceremize ekliyoruz ve silme işlemi
        JButton clear = new JButton("Temizle");
        clear.addActionListener(new ClearListener(canvas));
        top_bar.add(clear);

        // Kalınlık için slider ayarlaması ve kalınlık işlemi
        JLabel label1;
        label1 = new JLabel("Kalınlık");
        label1.setBounds(50,50, 100,30);
        JSlider slider = new JSlider(1, 100, 25);
        slider.addChangeListener(new SliderListener(canvas));
        top_bar.add(label1);
        top_bar.add(slider);

        // Renkler için combobox
        String[] colors = {"Siyah", "Kırmızı", "Mavi", "Yeşil","Turuncu"};
        JComboBox<String> combo = new JComboBox<>(colors);
        combo.addActionListener(new Colors(canvas));
        top_bar.add(combo);

        // Pencereyi göster
        frame.setVisible(true);
    }
}
