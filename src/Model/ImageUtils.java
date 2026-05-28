/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author mw300
 */
public class ImageUtils {

    public static ImageIcon resizeImage(String path, int width, int height) {

        ImageIcon icon = new ImageIcon(
                ImageUtils.class.getResource(path)
        );

        Image img = icon.getImage();

        Image scaled = img.getScaledInstance(
                width,
                height,
                Image.SCALE_SMOOTH
        );

        return new ImageIcon(scaled);
    }
}
