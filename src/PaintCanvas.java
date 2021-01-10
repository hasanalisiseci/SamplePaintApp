import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class PaintCanvas extends Canvas implements MouseListener, MouseMotionListener {

    // Çizim
    private BufferedImage cImage = null;
    // Çizim
    private Graphics2D g2d;

    // Tuval boyutları
    private int w;
    private int h;

    // Çizgi başlangıç bitiş konumları
    private int sx, sy, ex, ey;
    // Çizim modu: çiz (0), sil (1)
    private int type;
    // Hat kalınlığı
    public int width = 1;
    public Color c = Color.black;

    public PaintCanvas(int w, int h) {
        // Çizim tuvali
        // Koordinatlara başlangıç değerleri
        this.w = w;
        this.h = h;
        sx = sy = -1;
        ex = ey = -1;
        type = 0;

        // Mouse listener'ı ekleyelim
        addMouseListener(this);
        addMouseMotionListener(this);

        // Tuval arka planını beyaz olarak ayarla
        setBackground(Color.white);
        cImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        g2d = (Graphics2D) cImage.getGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, w, h);
        // Çizim
        repaint();
    }

    // Tuvali temizle
    public void clear() {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, w, h);
        repaint();
    }

    // Çizgi kalınlığını değiştir
    public void setStroke(int n) {
        width = n;
    }

    // Çizgi renk değişiöi
    public void setColorCombo(String color) {
        if (color.contentEquals("Siyah")) {
            c = Color.black;
        } else if (color.contentEquals("Kırmızı")) {
            c = Color.red;
        } else if (color.contentEquals("Mavi")) {
            c = Color.blue;
        } else if (color.contentEquals("Yeşil")) {
            c = Color.green;
        } else if (color.contentEquals("Turuncu")) {
            c = Color.orange;
        }
    }

    @Override
    public void paint(Graphics g) {
        // Çizim modu (çizgi çizme)
        if (type == 1) {
            if (sx >= 0 && sy >= 0 && ex >= 0 && ey >= 0) {
                BasicStroke stroke = new BasicStroke(width,
                        BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                g2d.setStroke(stroke);
                g2d.setColor(c);
                g2d.drawLine(ex, ey, sx, sy);
            }
        }
        // Silgi modu
        else if (type == 2) {
            if (sx >= 0 && sy >= 0 && ex >= 0 && ey >= 0) {
                // Yuvarlak uçlu bir çizgiye ayarlıyoruz
                BasicStroke stroke = new BasicStroke(50.0f,
                        BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                g2d.setStroke(stroke);
                g2d.setColor(Color.white);
                g2d.drawLine(ex, ey, sx, sy);
            }
        }

        // Tuvale çiziyoruz
        g.drawImage(cImage, 0, 0, null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        // Basılan düğmeyi algılar
        int mod = e.getModifiersEx();
        if ((mod & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
            // Sol tıklama (çizme modu)
            type = 1;
        }
        if ((mod & MouseEvent.BUTTON3_DOWN_MASK) != 0) {
            // Sağ tıklama (silgi modu)
            type = 2;
        }

        // Geçmiş koordinatları başlangıç ​​koordinatları olarak ayarla
        ex = sx;
        ey = sy;

        // Yeni koordinatları bitiş koordinatları olarak ayarlayın
        Point point = e.getPoint();
        sx = point.x;
        sy = point.y;

        // Çizim
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Sürükleme tamamlandığında koordinatları ilklendirin
        sx = sy = -1;
        ex = ey = -1;
        type = 0;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Nothing
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Koordinatları alıyoruz
        Point point = e.getPoint();
        sx = point.x;
        sy = point.y;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Nothing
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Nothing
    }
}
