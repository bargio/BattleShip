package Interface;

import Interface.FirstFrameLayout.*;
import jdk.nashorn.internal.runtime.Context;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gio2 on 07/01/2017.
 */
public class FirstFrame extends JFrame {
    private TitolFrame titol;
    private SecondPartFIrstFrame secondPart;
    private BorderLayout layout;
    private LayoutButtonContinue button;
    private final String p1 = "Player 1";
    private final String p2 = "Player 2 /  PC";

    public FirstFrame() {
        this.titol = new TitolFrame();
        this.secondPart = new SecondPartFIrstFrame(p1, p2);
        this.layout = new BorderLayout();
        this.button = new LayoutButtonContinue();
        layoutCreator();
    }

    private void layoutCreator() {
        this.setLayout(layout);
        this.add(titol, BorderLayout.NORTH);
        this.add(secondPart, BorderLayout.CENTER);
        this.add(button, BorderLayout.SOUTH);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }
}