public class Rectangle extends Shape {
    private int width;
    private int length;

    // Constructor to create a rectangle with position, width, and length
    public Rectangle(Coordinates coord, int width, int length) {
        super(4, coord);
        this.width = width;
        this.length = length;
    }

    // Scales the rectangle position, width, and length
    @Override
    public void scale(int factor, boolean sign) {
        position.scale(factor, sign);

        if (sign) {
            this.width *= factor;
            this.length *= factor;
        } else {
            this.width /= factor;
            this.length /= factor;
        }
    }

    // Calculates the area of the rectangle
    @Override
    public double getArea() {
        return width * length;
    }

    // Calculates the perimeter of the rectangle
    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    // Returns rectangle information as a string
    @Override
    public String display() {
        return "Shape: Rectangle\nPosition: " + position.display() +
                "\nWidth: " + width +
                "\nLength: " + length +
                "\nArea: " + String.format("%.2f", getArea()) +
                "\nPerimeter: " + String.format("%.2f", getPerimeter());
    }
}