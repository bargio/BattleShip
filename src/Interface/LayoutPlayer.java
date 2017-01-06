package Interface;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Gio on 06/01/2017.
 */
public class LayoutPlayer extends JPanel{
    private JLabel player;
    private JTextField nameP;
    private FlowLayout f;

    public LayoutPlayer(String player) {
        super();
        this.player = new JLabel(player);
        this.nameP = new JTextField(10);
        this.f = new FlowLayout(FlowLayout.CENTER);
        layoutCreator();
    }

    public void layoutCreator(){
        player.setFont(Font.getFont(Font.SANS_SERIF));
        player.setOpaque(true);
        this.setLayout(f);
        this.add(player);
        this.add(nameP);
    }
}
