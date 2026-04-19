public class Circle extends Shape {
    private double radius;

    // Constructor to create a circle with position and radius
    public Circle(Coordinates coord, double radius) {
        super(0, coord);
        this.radius = radius;
    }

    // Scales the circle position and radius
    @Override
    public void scale(int factor, boolean sign) {
        position.scale(factor, sign);

        if (sign) {
            this.radius *= factor;
        } else {
            this.radius /= factor;
        }
    }

    // Calculates the area of the circle
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Calculates the perimeter of the circle
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Returns circle information as a string
    @Override
    public String display() {
        return "Shape: Circle\nPosition: " + position.display() +
                "\nRadius: " + radius +
                "\nArea: " + String.format("%.2f", getArea()) +
                "\nPerimeter: " + String.format("%.2f", getPerimeter());
    }
}