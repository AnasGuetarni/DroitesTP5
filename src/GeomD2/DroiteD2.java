package GeomD2;

/**
 * Class GeomD2.DroiteD2
 */

public class DroiteD2 {
    private PointD2 p = null;
    private Double m = null;
    private PointD2 p2;
    private double ordonnee;

    // Constructor of GeomD2.DroiteD2 with a point and a slope
    public DroiteD2 (PointD2 p, Double m) {
        this.p = p;
        this.m = m;
        this.ordonnee =  -1*((int)Math.floor(m) * p.getX()) + p.getY();
    }

    // Constructor of GeomD2.DroiteD2 with a slope and an ordinate at the origin
    public DroiteD2 (Double m, double ord) {
        this.m = m;
        this.p = new PointD2(0, (int)ord);
        this.ordonnee = (int)ord;
    }

    // Constructor GeomD2.DroiteD2 with two Points
    public DroiteD2(PointD2 p1, PointD2 p2) {
        p = p1;
        this.p2 = p2;
        m = calc_pente(p1, p2);
        this.ordonnee =  getIntersectionY();
    }

    // Function who permit to calcul the slope between two points
    public static double calc_pente(PointD2 p1, PointD2 p2)
    {
        if(p2.getX() - p1.getX() != 0)
            return ((double)(p2.getY() - p1.getY()) / (double)(p2.getX() - p1.getX()));
        else
            return 1;
    }

    // Setters of Point and Slope
    public void setPoint(PointD2 p) {
        this.p = p;
    }
    public void setPente(Double m) {
        this.m = m;
    }
    public void setPointPente(PointD2 p, Double m) {
        setPoint(p);
        setPente(m);
    }

    // Getters of Point and Slope and ordinate
    public PointD2 getPoint(){
        return p;
    }
    public Double getPente(){
        return m;
    }
    public double getOrdonnee() {
        return  ordonnee;
    }

    // Getters of intersections of X and Y
    public Double getIntersectionX() {
        return -(getIntersectionY() / m);
    }
    public Double getIntersectionY() {
        return p.getY() - (m * p.getX());
    }

    // Function who permit to get y from x
    public double get_y_from_x(int x) {
        return x*m+getIntersectionY();
    }

    // Boolean function who can allow you to know if the Point is in the right
    public boolean contient(PointD2 p) {
        return this.m * p.getX() - p.getY() + getIntersectionY() == 0;
    }

    // Boolean function who tell you if it's the same slope
    public boolean same(DroiteD2 d) {
        return this.m == d.getPente();
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof DroiteD2) { //test si l'objet est de type GeomD2.DroiteD2
            DroiteD2 d1 = (DroiteD2)o;
            if (p == d1.p && m == d1.m) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return(p.toString() + "\nPente : " + m.toString());
    }
    public StringBuilder toString2() {
        return null;
    }

}
