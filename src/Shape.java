public abstract class Shape {
    protected Coordinates position;
    protected int sides;

    // Constructor to create a shape with number of sides and position
    public Shape(int noOfSides, Coordinates coord) {
        this.position = coord;
        this.sides = noOfSides;
    }

    // Returns the position of the shape
    public Coordinates getCoordinates() {
        return position;
    }

    // Returns the number of sides of the shape
    public int getSides() {
        return sides;
    }

    // Sets a new position for the shape
    public void setCoordinates(Coordinates newCoord) {
        this.position = newCoord;
    }

    // Translates the shape by moving its position
    public void translate(int dx, int dy) {
        position.translate(dx, dy);
    }

    // Abstract method to scale the shape
    public abstract void scale(int factor, boolean sign);

    // Abstract method to calculate area
    public abstract double getArea();

    // Abstract method to calculate perimeter
    public abstract double getPerimeter();

    // Abstract method to display shape information
    public abstract String display();
}