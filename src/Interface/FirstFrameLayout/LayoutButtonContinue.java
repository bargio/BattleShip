package Interface.FirstFrameLayout;

import Interface.ResizerImage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by gio2 on 06/01/2017.
 */
public class LayoutButtonContinue extends JPanel {
    private FlowLayout fl;
    private JButton next;
    private ImageIcon icon;
    private JLabel label;
    private String words;

    public  LayoutButtonContinue(){
        super();
        this.fl= new FlowLayout(FlowLayout.RIGHT);
        this.icon = new ImageIcon(getClass().getResource("/icon/proiettile.png"));
        icon = ResizerImage.resizeImage(icon,100,64);
        this.next = new JButton(icon);
        modifyButton();
        layoutCreator();

    }
    public  LayoutButtonContinue(String titol){
        super();
        this.fl= new FlowLayout(FlowLayout.RIGHT);
        this.icon = new ImageIcon(getClass().getResource("/icon/proiettile.png"));
        icon = ResizerImage.resizeImage(icon,100,64);
        this.next = new JButton(icon);
        this.words = titol;
        this.label = new JLabel(words);
        label.setFont(new Font("Serif",Font.BOLD,40));
        this.add(label);
        modifyButton();
        layoutCreator();

    }


    private void modifyButton() {
        Border c = BorderFactory.createEmptyBorder();
        next.setBackground(new Color(255,255,255, 0));
        next.setBorder(c);
        next.setContentAreaFilled(true);
        next.setForeground(new Color(255,255,255,0));
    }

    private void layoutCreator() {
        this.setLayout(fl);
        next.setPreferredSize(new Dimension(100,64));
        this.add(next);

    }
}
