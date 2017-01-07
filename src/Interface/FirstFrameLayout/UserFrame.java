package Interface.FirstFrameLayout;

import Interface.ResizerImage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gio2 on 06/01/2017.
 */
public class UserFrame extends JPanel{
    private FlowLayout fl;
    private JTextField name;
    private JLabel player,iconLabel;
    private ImageIcon icon;
    private final int DIM_TEXT_FIELD=5;

    public UserFrame(String player,String image){
        super();
        this.fl = new FlowLayout(FlowLayout.CENTER);
        this.name = new JTextField(DIM_TEXT_FIELD);
        this.icon = new ImageIcon(getClass().getResource(image));
        this.player = new JLabel(player);
        icon = ResizerImage.resizeImage(icon,20,20);
        this.iconLabel = new JLabel(icon);
        setDimension();
        layoutCreator();
    }

    private void layoutCreator() {

        this.setLayout(fl);
        this.add(iconLabel);
        this.add(player);
        this.add(name);
    }

    private void setDimension(){
        name.setToolTipText("ALIAS");
        name.setFont(new Font(Font.SANS_SERIF,0,20));
        player.setFont(new Font(Font.SANS_SERIF,0,20));
    }
}
