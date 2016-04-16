package screensaver;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Creates frame on a random place on a screen.
 *
 * Created by dkorolev on 4/16/2016.
 */
@org.springframework.stereotype.Component
public class ColorFrame extends JFrame {

    @Autowired
    private Color color;

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
        getContentPane().setBackground(color);
        //change color
        repaint();
    }
}
