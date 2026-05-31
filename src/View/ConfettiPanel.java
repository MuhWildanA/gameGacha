/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author mw300
 */
public class ConfettiPanel extends JPanel {
    private final ArrayList<Confetti> confettis = new ArrayList<>();
    private final Timer timer;

    public ConfettiPanel(int width, int height) {
        int centerX = width / 2;
        int centerY = height / 2;
        
        setOpaque(false);
        
        for (int i = 0; i < 200; i++){
            confettis.add(new Confetti(centerX, centerY));
        }
            
        timer = new Timer(10, e -> {
            for (Confetti c : confettis) {
                c.x += c.dx;
                c.y += c.dy;
                c.dy += 0.15; // Mengaktifkan efek gravitasi (opsional, biar setelah meledak dia jatuh anggun)

                if (c.y > getHeight()) {
                    c.y = -20;
                }  
            }
            repaint();
        });
        timer.start();
    }
        
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        // Mengaktifkan Antialiasing agar guratan bintang terlihat halus dan tajam (tidak pecah kotak-kotak)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Confetti c : confettis){
            g2.setColor(c.color);
            
            // Gambar bentuk Bintang Emas menggunakan metode pembentuk Path khusus
            g2.fill(createStar(c.x, c.y, c.size / 2.0, c.size, 5));
        }
    }
    
    /**
     * Helper Method untuk membentuk objek Bintang Berdasarkan Titik Koordinat
     */
    private Path2D createStar(double centerX, double centerY, double innerRadius, double outerRadius, int numRays) {
        Path2D path = new Path2D.Double();
        double startAngleRad = Math.toRadians(-90); // Memulai dari sudut puncak atas

        path.moveTo(
            centerX + outerRadius * Math.cos(startAngleRad),
            centerY + outerRadius * Math.sin(startAngleRad)
        );

        double angleStep = Math.PI / numRays;
        for (int i = 1; i < numRays * 2; i++) {
            double angle = startAngleRad + i * angleStep;
            double relRadius = (i % 2 == 0) ? outerRadius : innerRadius;
            path.lineTo(
                centerX + relRadius * Math.cos(angle),
                centerY + relRadius * Math.sin(angle)
            );
        }
        path.closePath();
        return path;
    }
        
    class Confetti {
        int x, y;
        int size;
        double dx;
        double dy;
        Color color;
        Random rand = new Random();
            
        public Confetti(int x, int y) {
            this.x = x;
            this.y = y;
            
            // Ukuran bintang emas bervariasi antara 8 sampai 18 piksel
            size = rand.nextInt(10) + 8;
            
            double angle = Math.toRadians(rand.nextInt(360));
            double speed = rand.nextDouble() * 8 + 4;
            dx = Math.cos(angle) * speed;
            dy = Math.sin(angle) * speed;
                
            // Variasi rumpun palet warna Emas (Gold Premium) agar visual ledakannya hidup dan mewah
            Color[] goldColors = {
                new Color(255, 215, 0),   // Gold standar berkilau
                new Color(245, 199, 26),  // Metallic Gold gacha
                new Color(255, 223, 0),   // Golden Yellow cerah
                new Color(218, 165, 32),  // Goldenrod (Emas gelap berbobot)
                new Color(255, 234, 115)  // Light Gold (Efek kilau cahaya)
            };
            
            // Pilih acak dari variasi warna emas di atas
            color = goldColors[rand.nextInt(goldColors.length)];
        }
    }
    
    public void stopConfetti(){
        timer.stop();
        setVisible(false);
    }
}