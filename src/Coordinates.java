public class Coordinates {
    private int x;
    private int y;

    // Constructor to create a coordinate with x and y values
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Returns the x value of the coordinate
    public int getX() {
        return x;
    }

    // Returns the y value of the coordinate
    public int getY() {
        return y;
    }

    // Calculates the distance between this coordinate and another coordinate
    public double distance(Coordinates p) {
        int distX = this.x - p.getX();
        int distY = this.y - p.getY();
        return Math.sqrt(distX * distX + distY * distY);
    }

    // Moves the coordinate by dx and dy
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    // Scales the coordinate by multiplying or dividing with the factor
    public void scale(int factor, boolean sign) {
        if (sign) {
            this.x *= factor;
            this.y *= factor;
        } else {
            this.x /= factor;
            this.y /= factor;
        }
    }

    // Returns the coordinate as a string
    public String display() {
        return "X = " + x + ", Y = " + y;
    }
}