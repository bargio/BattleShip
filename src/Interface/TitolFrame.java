package Interface;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Gio on 06/01/2017.
 */
public class TitolFrame extends JPanel {
    private JLabel battle, ship,imageIcon;
    private Container c;
    private BorderLayout bl;
    private FlowLayout fl;
    private ImageIcon icon;

    public TitolFrame(){
        super();
        this.battle = new JLabel("BATTAGLIA");
        this.ship = new JLabel("NAVALE");
        this.c = new Container();
        this.bl = new BorderLayout();
        this.fl = new FlowLayout(FlowLayout.CENTER);
        this.imageIcon = new JLabel();
        this.icon = new ImageIcon("resources/icon/13.png");
        layoutCreator();
    }

    private void layoutCreator() {
       this.setLayout(bl);
       resizeImage();
       imageIcon.setIcon(icon);
       battle.setHorizontalAlignment(JLabel.CENTER);
       ship.setHorizontalAlignment(JLabel.CENTER);
       imageIcon.setHorizontalAlignment(JLabel.CENTER);
       battle.setFont(new Font("Serif",Font.BOLD,20));
       ship.setFont(new Font("Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
       this.add(imageIcon,BorderLayout.CENTER);
       this.add(battle,BorderLayout.NORTH);
       this.add(ship,BorderLayout.SOUTH);

        }

    private void resizeImage(){
        Image image = icon.getImage();
        image = image.getScaledInstance(192,150, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
    }

}
