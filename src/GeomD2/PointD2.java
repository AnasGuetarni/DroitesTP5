package GeomD2;

/**
 * Class GeomD2.PointD2 with x and y principals parameters
 */

public class PointD2 {
    // Initialization of x and y values at null
    private Integer x = null;
    private Integer y = null;

    // Empty constructor of GeomD2.PointD2
    public PointD2() { }

    // Constructor GeomD2.PointD2 with 2 int as parameters who correspond to x and y
    public PointD2(int a, int b) {
        x = new Integer(a); //conversion implicite de int en Integer
        y = new Integer(b);
    }

    // Constructor GeomD2.PointD2 with one parameters who correspond to a point with an x and a y parameters
    public PointD2(PointD2 pt) {
        x = pt.x;
        y = pt.y;
    }

    // Constructor GeomD2.PointD2 with one tab who contains x and y values
    public PointD2(Integer[] pt) {
        x = pt[0];
        y = pt[1];
    }

    // Getter of x and y
    public Integer getX() {
        return x;
    }
    public Integer getY() {
        return y;
    }

    // Setter of x and y
    public void setX(Integer X) {
        this.x = X;
    }
    public void setY(Integer Y) {
        this.y = Y;
    }


    // Boolean method if the values of x and y are assigned
    public boolean defini() {
        return (x != null) && (y != null);
    }

    public double dist(PointD2 pt) {
        double dx = (double)x, dy = (double)y, dx2 = (double)pt.x, dy2 = (double)pt.y;
        return Math.sqrt(Math.pow((dx2 - dx), 2) + Math.pow(dy2 - dy, 2));
    }

    @Override
    public String toString() {
        return("x : " + x + "y : " + y);
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof PointD2) { //test si l'objet est de type GeomD2.PointD2
            PointD2 pt = (PointD2)o;
            if (x == pt.x && y == pt.y) {
                return true;
            }
        }
        return false;
    }

}
