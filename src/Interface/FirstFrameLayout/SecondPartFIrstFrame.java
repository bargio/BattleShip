package Interface.FirstFrameLayout;

import Interface.ResizerImage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gio2 on 06/01/2017.
 */
public class SecondPartFIrstFrame extends JPanel {
    private UserFrame user1,user2;
    private JCheckBox vsPc;
    private ImageIcon icon,iconChecked;
    private String player1,player2;
    private BorderLayout bd;
    private GridLayout gd;
    private String imageDir;


    public SecondPartFIrstFrame(String namePlayer1,String namePlayer2){
        super();
        this.player1 = namePlayer1;
        this.player2 = namePlayer2;
        this.imageDir = "/icon/milit.png";
        this.user1 = new UserFrame(player1,imageDir);
        this.user2 = new UserFrame(player2,imageDir);
        this.bd = new BorderLayout();
        this.icon = new ImageIcon(getClass().getResource("/icon/pc.png"));
        this.iconChecked = new ImageIcon(getClass().getResource("/icon/check.png"));
        iconChecked = ResizerImage.resizeImage(iconChecked,40,40);
        icon = ResizerImage.resizeImage(icon,40,40);
        this.vsPc = new JCheckBox("vsPc",icon);
        checkBoxSetting();
        this.gd = new GridLayout(0,1);
        setDimensione();
        layoutCreator();
    }

    private void checkBoxSetting() {
    vsPc.setSelectedIcon(iconChecked);
    vsPc.setPressedIcon(iconChecked);
        }

    private void setDimensione() {
        vsPc.setHorizontalAlignment(SwingConstants.CENTER);
        vsPc.setPreferredSize(new Dimension(100,100));
    }

    private void layoutCreator() {
        this.setLayout(bd);
        this.add(vsPc,BorderLayout.NORTH);
        Container c = new Container();
        c.setLayout(gd);
        c.add(user1);
        c.add(user2);
        this.add(c,BorderLayout.CENTER);

    }
}

