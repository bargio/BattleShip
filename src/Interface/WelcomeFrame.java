package Interface;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Gio on 06/01/2017.
 */
public class WelcomeFrame extends JPanel {
    private BorderLayout bl;
    private LayoutPlayer f1,f2;
    private JLabel titol;
    private JButton nextLayout;
    private Container c;
    public WelcomeFrame(){
        super();
        this.bl = new BorderLayout();
        this.f1 = new LayoutPlayer("Giocatore 1");
        this.f2 = new LayoutPlayer("Giocatore 2");
        this.titol = new JLabel("BATTAGLIA NAVALE");
        this.nextLayout = new JButton("Prossimo");
        this.c = new Container();

        creatorWelcomeLayout();
    }
    public void creatorWelcomeLayout(){
        this.setLayout(bl);
        this.add(titol,BorderLayout.NORTH);
        c.setLayout(new GridLayout(1,1));
        c.add(f1);
        c.add(f2);
        nextLayout.setSize(new Dimension(20,20));
        this.add(c,BorderLayout.CENTER);
        this.add(nextLayout, BorderLayout.SOUTH);
    }
}
