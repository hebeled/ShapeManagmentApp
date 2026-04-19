public class Square extends Shape {
    private int side;

    // Constructor to create a square with position and side length
    public Square(Coordinates coord, int side) {
        super(4, coord);
        this.side = side;
    }

    // Scales the square position and side length
    @Override
    public void scale(int factor, boolean sign) {
        position.scale(factor, sign);

        if (sign) {
            this.side *= factor;
        } else {
            this.side /= factor;
        }
    }

    // Calculates the area of the square
    @Override
    public double getArea() {
        return side * side;
    }

    // Calculates the perimeter of the square
    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    // Returns square information as a string
    @Override
    public String display() {
        return "Shape: Square\nPosition: " + position.display() +
                "\nSide: " + side +
                "\nArea: " + String.format("%.2f", getArea()) +
                "\nPerimeter: " + String.format("%.2f", getPerimeter());
    }
}