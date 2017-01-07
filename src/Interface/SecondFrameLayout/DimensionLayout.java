package Interface.SecondFrameLayout;

import Interface.FirstFrameLayout.UserFrame;
import Interface.ResizerImage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gio2 on 07/01/2017.
 */
public class DimensionLayout extends JPanel {
    private UserFrame height,width;
    private String heigthString, widthString,imageHeightDir,imageWidthDir;
    private ImageIcon iconHeight, iconWidth;
    private BorderLayout bd;

    public DimensionLayout(){
        super();
        this.bd = new BorderLayout();
        this.heigthString = "Altezza";
        this.widthString = "Lungezza";
        this.imageHeightDir =  "/icon/Height-48.png";
        this.imageWidthDir= "/icon/Width-48.png";

        this.height = new UserFrame(heigthString,imageHeightDir);
        this.width = new UserFrame(widthString,imageWidthDir);
        layoutCreator();
    }

    private void layoutCreator() {
        this.setLayout(bd);
        this.add(height,BorderLayout.NORTH);
        this.add(width,BorderLayout.CENTER);

    }
}
