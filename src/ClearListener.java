import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Ekranı temizlemek istediğimizde buraya ulaşacağız.
public class ClearListener implements ActionListener {
    //Kullanıcıdan gelen inputları yakalayabilecek ve çizim
    // olanağı sağlayacak canvasımızı oluşturuyoruz
    PaintCanvas canvas;

    //constructor'ımızı oluşturduk
    public ClearListener(PaintCanvas canvas) {
        super();
        this.canvas = canvas;
    }
    //Temizle butonu ile aktif hale gelen
    // clear işlemini gerçekleştiren methodumuz
    @Override
    public void actionPerformed(ActionEvent e) {
        canvas.clear();
    }
}
