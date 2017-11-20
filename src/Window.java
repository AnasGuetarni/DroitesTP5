import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Main function in the program
 */
public class Window {
    public static void main (String args[]) {
        // We declare a liste of Points
        DataPoints listePts = new DataPoints("point.txt");
        // We create the graph with the list of Points
        DessinPoints monGraphe = new DessinPoints(listePts,600,400,10,10);

        // We create the Frame with his properties
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(monGraphe,"Center");
        f.setTitle("Grapheur");
        f.setSize(600,400);
        f.setContentPane(monGraphe);

        // We set the graph as visible
        f.setVisible(true);
    }
}
