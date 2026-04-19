public class Circle extends Shape {
    private double radius;

    public Circle(Coordinates coord, double radius) {
        super(0, coord);
        this.radius = radius;
    }

    @Override
    public void scale(int factor, boolean sign) {
        position.scale(factor, sign);

        if (sign) {
            this.radius *= factor;
        } else {
            this.radius /= factor;
        }
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String display() {
        return "Shape: Circle\nPosition: " + position.display() +
                "\nRadius: " + radius +
                "\nArea: " + String.format("%.2f", getArea()) +
                "\nPerimeter: " + String.format("%.2f", getPerimeter());
    }
}