package objects;

public class Point { 
    private final double x;   // Cartesian
    private final double y;   // coordinates
   
    // creates and initializes a point with given (x, y)
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // return the Euclidean distance between the two points
    public double distanceTo(Point that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    // draw point using standard draw
    public void draw() {
        // StdDraw.point(x, y);
    }

    // draw the line from the invoking point p to q using standard draw
    public void drawTo(Point that) {
        //StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // return string representation of this point
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
