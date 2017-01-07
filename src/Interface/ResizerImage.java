package Interface;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gio2 on 07/01/2017.
 */
public class ResizerImage {

    public static ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        return icon;
    }
}
