package View;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BannerPanel extends JPanel {
   private BufferedImage currentImage;
    private BufferedImage nextImage;
    
    private float alpha = 1.0f; // 1.0f artinya kelihatan penuh
    private Timer fadeTimer;
    private static final int FADE_DURATION = 400; // Total waktu fade (400ms)
    private static final int REFRESH_RATE = 25;   // Update tiap 25ms biar smooth (40 FPS)

    public void setImage(BufferedImage image) {
        if (this.currentImage == null) {
            this.currentImage = image;
            repaint();
            return;
        }

        // Jalankan efek fade: Gambar lama jadi current, gambar baru jadi next
        this.nextImage = image;
        this.alpha = 1.0f; // Mulai dari opacity penuh gambar lama, lalu pelan-pelan pudar

        if (fadeTimer != null && fadeTimer.isRunning()) {
            fadeTimer.stop();
        }

        // Hitung berapa kali alpha harus dikurangi tiap refresh rate
        float alphaStep = (float) REFRESH_RATE / FADE_DURATION;

        fadeTimer = new Timer(REFRESH_RATE, e -> {
            alpha -= alphaStep;
            
            if (alpha <= 0.0f) {
                alpha = 0.0f;
                fadeTimer.stop();
                // Transisi selesai, ganti gambar utama menjadi gambar baru
                currentImage = nextImage;
                nextImage = null;
                alpha = 1.0f; // Kembalikan ke normal
            }
            repaint();
        });
        
        fadeTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        
        // Aktifkan anti-aliasing biar transisinya halus gak pecah
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        int w = getWidth();
        int h = getHeight();

        if (nextImage != null) {
            // 1. Gambar 'Next Image' (Gambar baru) di latar belakang dulu (Alpha penuh)
            g2d.drawImage(nextImage, 0, 0, w, h, this);

            // 2. Gambar 'Current Image' (Gambar lama) di atasnya dengan Alpha yang mengecil (Fade Out)
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            g2d.drawImage(currentImage, 0, 0, w, h, this);
        } else {
            // Kondisi normal kalau gak lagi transisi
            if (currentImage != null) {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
                g2d.drawImage(currentImage, 0, 0, w, h, this);
            }
        }

        g2d.dispose();
    }
}