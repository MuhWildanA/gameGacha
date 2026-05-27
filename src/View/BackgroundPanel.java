
package View;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
     private Image backgroundImage;

    public BackgroundPanel() {

        backgroundImage = new ImageIcon(
            getClass().getResource("/assets/images/bg.png")
        ).getImage();

        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(
            backgroundImage,
            0,
            0,
            getWidth(),
            getHeight(),
            this
        );
    }
}
