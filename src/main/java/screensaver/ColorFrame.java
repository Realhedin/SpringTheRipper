package screensaver;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Creates frame on a random place on a screen.
 *
 * Created by dkorolev on 4/16/2016.
 */
@org.springframework.stereotype.Component
public abstract class ColorFrame extends JFrame {

    public ColorFrame()  {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * show frame on a random place on a screen.
     */
    public void showOnRandomPlace() {
        //set random place on a screen
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(700));
        //set color of frame
        getContentPane().setBackground(getColor());
        //change color
        repaint();
    }

    /**
     * Abstract method for solution
     * how to inject Prototype into Singleton.
     * Implementation inside Java Config to be able
     * to use Context in a right way.
     *
     * @return Color object.
     */
    protected abstract Color getColor();
}
