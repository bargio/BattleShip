package Interface;

import Interface.FirstFrameLayout.LayoutButtonContinue;
import Interface.SecondFrameLayout.DimensionLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gio2 on 07/01/2017.
 */
public class SecondFrame extends JFrame {
    private BorderLayout bd;
    private ImageIcon map;
    private JLabel titolFrame,image;
    private DimensionLayout dl;
    private String dirImage;
    private LayoutButtonContinue button;
    public SecondFrame(){
        super();
        this.bd = new BorderLayout();
        this.dirImage = "/icon/map.png";
        this.map = new ImageIcon(getClass().getResource(dirImage));
        map = ResizerImage.resizeImage(map,map.getIconWidth()/2,map.getIconHeight()/2);
        this.image = new JLabel(map);
        //this.titolFrame = new JLabel("Dimensione Mappa");
        this.dl = new DimensionLayout();
        this.button = new LayoutButtonContinue("Dimensione Mappa    ");
        layoutCreator();

    }

    private void layoutCreator() {
        this.setLayout(bd);
//        titolFrame.setHorizontalAlignment(JLabel.CENTER);
        dl.setAlignmentY(10);
     //   resizeFont();
       // this.add(titolFrame,BorderLayout.NORTH);
        this.add(image,BorderLayout.EAST);
        this.add(dl,BorderLayout.CENTER);
        this.add(button,BorderLayout.SOUTH);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
    }
    private void resizeFont(){
        titolFrame.setFont(new Font("Serif",Font.BOLD,40));

    }


}
