/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author mw300
 */
public class CharacterDisplayPanel extends JPanel{
     private Image image;

    public CharacterDisplayPanel (String path) {

        image = new ImageIcon(
                getClass().getResource(path)
        ).getImage();

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR
        );

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int imgWidth = image.getWidth(this);
        int imgHeight = image.getHeight(this);

        double scale = Math.min(
                (double) panelWidth / imgWidth,
                (double) panelHeight / imgHeight
        );

        int newWidth = (int) (imgWidth * scale);
        int newHeight = (int) (imgHeight * scale);

        int x = (panelWidth - newWidth) / 2;
        int y = (panelHeight - newHeight) / 2;

        g2.drawImage(
                image,
                x,
                y,
                newWidth,
                newHeight,
                this
        );
    }
}
