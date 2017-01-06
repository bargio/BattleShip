package Interface;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Gio on 06/01/2017.
 */
public class FrameInterface extends JFrame {
    private WelcomeFrame wf;
    private FlowLayout fl;
    private TitolFrame tl;
    public FrameInterface(){

        super("BATTAGLIA NAVALE");
        this.fl = new FlowLayout(FlowLayout.CENTER);
        this.wf = new WelcomeFrame();
        this.tl = new TitolFrame();
        layoutCreator();

    }

    private void layoutCreator() {
        this.setLayout(fl);
        this.add(tl);
        this.setVisible(true);
        this.pack();
    }
}
