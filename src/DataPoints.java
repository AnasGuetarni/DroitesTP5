import GeomD2.PointD2;

import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * Class DataPoints who extend a 2d array of GeomD2.PointD2
 */

public class DataPoints extends ArrayList<ArrayList<PointD2>> {
    // We declare the max of the values of x and y and the extends of these values
    Integer max_x;
    Integer max_y;
    Integer min_x;
    Integer min_y;
    int extendX;
    int extendY;

    /**
     * Constructor of the Datapoints
     * @param fichier who correspond to the input file of Points
     */

    public DataPoints (String fichier) {
        // We create a LineNumberReader to read the file lines
        LineNumberReader lecteurDeLignes = null;
        // We try to read the line in the file
        try {
            lecteurDeLignes = new LineNumberReader(new FileReader(fichier));
            String texteDeLigne = null;

            // We read the file line after line
            while ((texteDeLigne = lecteurDeLignes.readLine()) != null) {
                ArrayList<PointD2> tab_point = new ArrayList<PointD2>();

                // We Tokenise the file
                StringTokenizer st = new StringTokenizer(texteDeLigne);

                // We try to do the separation between a Point or a Right
                try {
                    if(st.countTokens() == 2 || st.countTokens() == 4) {
                        int x1 = Integer.parseInt(st.nextToken());
                        int y1 = Integer.parseInt(st.nextToken());
                        PointD2 pt1 = new PointD2(x1, y1);
                        tab_point.add(pt1);

                        // This is the case if we have a Right we create an other Point
                        if (st.countTokens() == 2) {
                            int x2 = Integer.parseInt(st.nextToken());
                            int y2 = Integer.parseInt(st.nextToken());
                            PointD2 pt2 = new PointD2(x2, y2);
                            tab_point.add(pt2);
                        }
                        // We add the point in the tab
                        this.add(tab_point);
                    }
                    else {
                        // Else if the tokenisation isn't good we throw an Exception of an InvalidNumber
                        throw new InvalidNumber();
                    }
                // If we catch an Invalid Input
                } catch (InvalidInput EI) {
                    EI.printStackTrace();
                }
                // If we catch an Invalid Number
                catch (InvalidNumber MN) {
                    MN.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lecteurDeLignes != null) {
                try {
                    lecteurDeLignes.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            // We call the min_max function
            min_max();
        }
    }

    /**
     *  Function to get the min and max of the current element and the extends
     */

    public void min_max() {
        // We initialise the value of max and min of x and y with getting the current value of the Point
        max_x = this.get(0).get(0).getX();
        max_y = this.get(0).get(0).getY();
        min_x = this.get(0).get(0).getX();
        min_y = this.get(0).get(0).getY();

        // We loop into the size of the current element
        for(int i = 0; i < this.size(); i++)
            for(int j = 0; j < this.get(i).size(); j++) {
                PointD2 pt = this.get(i).get(j);

                if (max_x < pt.getX())
                    max_x = pt.getX();

                if (max_y < pt.getY())
                    max_y = pt.getY();

                if (min_x > pt.getX())
                    min_x = pt.getX();

                if (min_y > pt.getY())
                    min_y = pt.getY();
            }

        // We initialize the value of the extends by casting the value
        this.extendX = (int) (max_x - min_x);
        this.extendY = (int) (max_y - min_y);

    }
}
