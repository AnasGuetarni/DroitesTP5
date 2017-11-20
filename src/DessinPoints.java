import GeomD2.DroiteD2;
import GeomD2.PointD2;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

/**
 * Class DessinPoints who extends JPanel
 */

public class DessinPoints extends JPanel {
    // We create a list of Points, the edge size, the dimension of the rectangles, a array of the initial size and a boolean if we entered
    DataPoints listePts;
    int edge;
    int enveloppe;
    int initiale_size[];
    boolean enter_once = true;

    /**
     * Constructor of the class DessinPoints
     * @param pts is a list of points
     * @param width is the width
     * @param height is the height
     * @param edge if the edge size
     * @param enveloppe is the dimension of the rectangles
     */

    DessinPoints(DataPoints pts, int width, int height, int edge, int enveloppe) {
        this.listePts = pts;
        this.edge = edge;
        this.enveloppe = enveloppe;
        // We initialize the size with the width and the height
        this.setSize(width, height);
        initiale_size = new int[2];
    }

    /**
     * Function who draw the points
     * @param point is a GeomD2.PointD2 point
     * @param g is a graphic
     * @param FactEchX is a double param who correspond to the scale factor of X
     * @param FactEchY is a double param who correspond to the scale factor of Y
     * @return a tab of double
     */
    private double[] dessine_point(PointD2 point, Graphics g, double FactEchX, double FactEchY)
    {
        double ret[] = new double[2];
        double x = point.getX() / FactEchX;
        double y = point.getY() / FactEchY;

        // We create a Rectangle2D
        ((Graphics2D)g).draw(new Rectangle2D.Double(x-(double)this.enveloppe/2 ,y-(double)this.enveloppe/2 , this.enveloppe, this.enveloppe));

        ret[0] = x;
        ret[1] = y;

        return ret;
    }

    /**
     * Function who paint all the component of the Graph
     * @param g is a Graphic
     */
    public void paintComponent(Graphics g)
    {
        // We initialize the height and the width
        if(enter_once)
        {
            enter_once = false;

            initiale_size[0] = this.getWidth();
            initiale_size[1] = this.getHeight();
        }

        // We initialize the scales factors
        double FactEchX = (double)initiale_size[0] / (double)this.getSize().width;
        double FactEchY = (double)initiale_size[1] / (double)this.getSize().height;

        // We call the super constructor to paint the graph
        super.paintComponent(g);
        g.setXORMode(Color.red);

        for(int i = 0; i < this.listePts.size(); i++) {
            // If it's a right
            if(this.listePts.get(i).size() > 1)
            {
                double ret_1[] = new double[2];
                double ret_2[] = new double[2];

                // We create the points
                ret_1 = dessine_point(this.listePts.get(i).get(0), g, FactEchX, FactEchY);
                ret_2 = dessine_point(this.listePts.get(i).get(1), g, FactEchX, FactEchY);

                // We create the right for the two points
                DroiteD2 droite = new DroiteD2(new PointD2((int) ret_1[0], (int) ret_1[1]), new PointD2((int) ret_2[0], (int) ret_2[1]));

                // We paint it into the the graph
                ((Graphics2D)g).draw(new Line2D.Double(0 , droite.getOrdonnee(), this.getWidth(), droite.get_y_from_x(this.getWidth())));
            }
            // Else if it's a point
            else
                dessine_point(this.listePts.get(i).get(0), g, FactEchX, FactEchY);
        }
    }
}
